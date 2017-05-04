package heiheihei.date0420;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/19
 */
public class Client {

	private static final String CMD_LOGIN_USERNAME = "name";
	private static final String CMD_LOGIN_PASSWORD = "pwd";
	private static final String CMD_SEND_MESSAGE = "message";
	private static final String CMD_BROADCAST = "broadcast";
	private static final String CMD_WHOELSE = "whoelse";
	private static final String CMD_WHOELSE_SINCE = "whoelsesince";
	private static final String CMD_BLOCK = "block";
	private static final String CMD_UNBLOCK = "unblock";
	private static final String CMD_LOGOUT = "logout";
	private static final String CMD_START_PRIVATE = "startprivate";
	private static final String CMD_PRIVATE = "private";
	private static final String CMD_STOP_PRIVATE = "stopprivate";
	private static final String CMD_ERROR = "error";

	private User mUser;
	private Socket mSocket;
	private ObjectOutputStream mOutputStream;

	private ObjectOutputStream privateOutputStream;
	private ObjectInputStream privateInputStream;

	private String server_IP = "localhost";
	private int server_port = 1234;

	public static void main(String[] args) {
		new Client(args[0], Integer.parseInt(args[1]));
//		new Client();
	}

	public Client(String server_IP, int server_port) {
//	public Client() {
		try {
			this.server_IP = server_IP;
			this.server_port = server_port;
			mSocket = new Socket(server_IP, server_port);
			mOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
			work();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client(Socket socket) throws IOException {
		this.mOutputStream = new ObjectOutputStream(socket.getOutputStream());
	}

	public void setUser(User user) {
		this.mUser = user;
	}

	private void work() {
		Scanner scan = new Scanner(System.in);
		try {
			String username = getInfo("Username", scan);
			sendMessage(new Message(username, CMD_LOGIN_USERNAME, username, 0));
			ObjectInputStream inputStream = new ObjectInputStream(mSocket.getInputStream());
			boolean flag = true;
			while (true) {
				if (flag) {
					flag = false;
				} else {
					username = getInfo("Username", scan);
					sendMessage(new Message(username, CMD_LOGIN_USERNAME, username, 0));
				}
				Message message = (Message) inputStream.readObject();
				if (message.getCode() == 0) {
					break;
				} else if (message.getCode() == 1) {
					System.out.println("This user has logged in.");
				} else if (message.getCode() == 2) {
					System.out.println("This user doesn't exist.");
				}

			}

			while (mUser == null) {
				String password = getInfo("Password", scan);
				sendMessage(new Message(username, CMD_LOGIN_PASSWORD, password, 0));
				Message message = (Message) inputStream.readObject();
				switch (message.getCode()) {
					case 0:
						mUser = (User) message.getContent();
						System.out.println("Welcome to the greatest messaging application ever!");
						break;
					case 1:
						System.out.println("Invalid Password. Please try again.");
						break;
					case 2:
						System.out.println("Invalid Password. Your account has been blocked. Please try again later.");
						System.exit(0);
						break;
					case 3:
						System.out.println("Your account is blocked due to multiple login failures. Please try again later.");
						break;
				}
			}

			ReceiveMessageClientThread receiveThread = new ReceiveMessageClientThread(inputStream);
			new Thread(receiveThread).start();

			while (scan.hasNext()) {
				switch (scan.next()) {
					case CMD_SEND_MESSAGE:
						sendMessage(new Message(scan.next(), CMD_SEND_MESSAGE, scan.nextLine().trim(), 0));
						break;
					case CMD_BROADCAST:
						sendMessage(new Message(null, CMD_BROADCAST, scan.nextLine().trim(), 0));
						break;
					case CMD_WHOELSE:
						sendMessage(new Message(null, CMD_WHOELSE, null, 0));
						break;
					case CMD_WHOELSE_SINCE:
						sendMessage(new Message(null, CMD_WHOELSE_SINCE, scan.next(), 0));
						break;
					case CMD_BLOCK:
						sendMessage(new Message(null, CMD_BLOCK, scan.next(), 0));
						break;
					case CMD_UNBLOCK:
						sendMessage(new Message(null, CMD_UNBLOCK, scan.next(), 0));
						break;
					case CMD_START_PRIVATE:
						sendMessage(new Message(null, CMD_START_PRIVATE, scan.next(), 0));
						break;
					case CMD_PRIVATE:
						String targetName = scan.next();
						String content = scan.nextLine().trim();
						if (privateOutputStream == null) {
							System.out.println("Error. Private messaging to " + targetName + " not enabled");
						} else {
							privateOutputStream.writeObject(new Message(null, CMD_PRIVATE, mUser.getUsername() + "(private): " + content, 0));
							privateOutputStream.flush();
						}
						break;
					case CMD_STOP_PRIVATE:
						targetName = scan.next();
						System.out.println("Stop private messaging to " + targetName);
						if (privateOutputStream == null) {
						} else {
							privateOutputStream.writeObject(new Message(null, CMD_STOP_PRIVATE, null, 0));
							privateOutputStream.flush();
						}
						break;
					case CMD_LOGOUT:
						sendMessage(new Message(null, CMD_LOGOUT, null, 0));
						break;
					default:
						System.out.println("Error. Invalid command");
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Message message) {
		try {
			mOutputStream.writeObject(message);
			mOutputStream.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private String getInfo(String info, Scanner scan) {
		System.out.print(info + ": ");
		return scan.nextLine();
	}

	public User getUser() {
		return mUser;
	}

	private class ReceiveMessageClientThread implements Runnable {
		private ObjectInputStream inputStream;

		public ReceiveMessageClientThread(ObjectInputStream inputStream) {
			this.inputStream = inputStream;
		}

		@Override
		public void run() {
			int privatePort;
			boolean isRunning = true;
			try {
				while (isRunning) {
					Message message = (Message) inputStream.readObject();
					switch (message.getCommand()) {
						case CMD_SEND_MESSAGE:
							switch (message.getCode()) {
								case 0:
									System.out.println(message.getContent().toString());
									break;
								case 1:
									System.out.println("Your message could not be delivered as the recipient has blocked you");
									break;
								case 2:
									System.out.println("The recipient is offline, message has been sent");
									break;
								case 3:
									System.out.println("Error. Invalid user");
									break;
							}
							break;
						case CMD_BROADCAST:
							if (message.getUsername() == null && message.getCode() == 1) {
								System.out.println("Your message could not be delivered to some recipients");
							} else {
								System.out.println(message.getContent().toString());
							}
							break;
						case CMD_BLOCK:
							switch (message.getCode()) {
								case 1:
									System.out.println("Error. " + message.getContent() + " has been blocked.");
									break;
								case 2:
									System.out.println("Error. Cannot block self");
									break;
								case 3:
									System.out.println("Error. Invalid user");
									break;
								default:
									System.out.println(message.getContent() + " is blocked.");
									break;
							}
							break;
						case CMD_UNBLOCK:
							if (message.getCode() == 0) {
								System.out.println(message.getContent() + " is unblocked.");
							} else {
								System.out.println("Error. " + message.getContent() + " was not blocked");
							}
							break;
						case CMD_LOGOUT:
							if (message.getCode() == 0) {
								System.out.println(message.getContent().toString());
							} else {
								System.out.println("Time out. Force offline");
							}
							break;
						case CMD_START_PRIVATE:
							switch (message.getCode()) {
								case 0:
									System.out.println("Start private success.");
									privatePort = (int) message.getContent();
									ServerSocket serverSocket = new ServerSocket(privatePort);
									Socket socket = serverSocket.accept();
									privateOutputStream = new ObjectOutputStream(socket.getOutputStream());
									privateInputStream = new ObjectInputStream(socket.getInputStream());
									new Thread(new ReceiveMessageClientThread(privateInputStream)).start();
									break;
								case 1:
									privatePort = (int) message.getContent();
									socket = null;
									while (socket == null) {
										try {
											socket = new Socket(server_IP, privatePort);
										} catch (Exception eee) {
											eee.printStackTrace();
											continue;
										}
									}
									System.out.println(String.format("Private messaging with %s started.", message.getUsername()));
									privateOutputStream = new ObjectOutputStream(socket.getOutputStream());
									privateInputStream = new ObjectInputStream(socket.getInputStream());
									new Thread(new ReceiveMessageClientThread(privateInputStream)).start();
									break;
								case 2:
									System.out.println("Error. Private messaging to " + message.getContent() + " not enabled");
									break;
							}
							break;
//						case CMD_PRIVATE:
//							break;
						case CMD_STOP_PRIVATE:
							isRunning = false;
							System.out.println("Private messaging stopped.");
							break;
						case CMD_ERROR:
							System.out.println("input invalid");
							break;
						default:
							System.out.println(message.getContent().toString());
							break;
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
