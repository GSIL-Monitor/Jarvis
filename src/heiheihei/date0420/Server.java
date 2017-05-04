package heiheihei.date0420;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/19
 */
public class Server {

	public static final String USER_FILE_PATH = "credentials.txt";

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

	private Map<String, Client> mOnlineClientMap;
	private Map<String, List<String>> mOfflineMessageMap;
	private Map<String, User> mTotalUserMap;

	private int server_port = 1234;
	private int block_duration = 60;
	private int timeout = 120;
	private int private_port;

	public static void main(String[] args) throws IOException {
		new Server(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
//		new Server();
	}

	public Server(int server_port, int block_duration, int timeout) {
//	public Server() {
		this.server_port = server_port;
		this.private_port = server_port + 1;
		this.block_duration = block_duration;
		this.timeout = timeout;

		log(null, null, "initing......");
		initTotalUserMap();
		initOfflineMessageMap();
		log(null, null, "server started.");

		try {
			mOnlineClientMap = new HashMap<>();
			ServerSocket serverSocket = new ServerSocket(server_port);
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new ServerThread(socket)).start();
			}
		} catch (BindException be) {
			be.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void initTotalUserMap() {
		mTotalUserMap = new HashMap<>();
		File file = new File(USER_FILE_PATH);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s;
			while ((s = reader.readLine()) != null) {
				String[] data = s.split(" ");
				if (data.length < 2) {
					continue;
				}
				mTotalUserMap.put(data[0], new User(data[0], data[1]));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void initOfflineMessageMap() {
		mOfflineMessageMap = new HashMap<>();
		for (String username : mTotalUserMap.keySet()) {
			mOfflineMessageMap.put(username, new ArrayList<>());
		}
	}

	private User getUserByName(String username) {
		return mTotalUserMap.get(username);
	}

	public void log(String username, String opeartion, String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(username == null ? "System " : ("User " + username));
		sb.append(opeartion == null ? "" : (" " + opeartion));
		sb.append(message == null ? "" : (": " + message));
		System.out.println(sb.toString());
	}

	private void log(Message message) {
		System.out.println(message.toString());
	}

	private class ServerThread implements Runnable {
		private Socket mSocket;
		private User mUser;
		private Client mClient;
		private ObjectInputStream mInputStream;
		private boolean isOnline;

		public ServerThread(Socket socket) throws IOException {
			this.mSocket = socket;
			mClient = new Client(socket);
			isOnline = false;
			mInputStream = new ObjectInputStream(socket.getInputStream());
		}

		@Override
		public void run() {
			try {
				onBeforeOnline();
				while (isOnline) {
					if ((System.currentTimeMillis() - mUser.getLastAliveTime()) > timeout * 1000) {
						isOnline = false;
					}
					Message message = (Message) mInputStream.readObject();
					mUser.setLastAliveTime(System.currentTimeMillis());
					try {
						switch (message.getCommand()) {
							case CMD_SEND_MESSAGE:
								String targetUsername = message.getUsername();
								String content = (String) message.getContent();
								sendMessage(targetUsername, content);
								break;
							case CMD_BROADCAST:
								content = (String) message.getContent();
								sendBroadcast(wrapContent(content));
								break;
							case CMD_WHOELSE:
								sendWhoElse();
								break;
							case CMD_WHOELSE_SINCE:
								int time = Integer.parseInt((String) message.getContent());
								sendWhoElseSince(time);
								break;
							case CMD_BLOCK:
								String blockName = (String) message.getContent();
								if (blockName.equals(mUser.getUsername())) {
									mClient.sendMessage(new Message(null, CMD_BLOCK, null, 2));
								} else {
									if (!mTotalUserMap.containsKey(blockName)) {
										mClient.sendMessage(new Message(null, CMD_BLOCK, blockName, 3));
									} else {
										if (mUser.blockUser(blockName)) {
											mClient.sendMessage(new Message(null, CMD_BLOCK, blockName, 0));
										} else {
											mClient.sendMessage(new Message(null, CMD_BLOCK, blockName, 1));
										}
									}
								}
								break;
							case CMD_UNBLOCK:
								String unBlockName = (String) message.getContent();
								if (mUser.unblockUser(unBlockName)) {
									mClient.sendMessage(new Message(null, CMD_UNBLOCK, unBlockName, 0));
								} else {
									mClient.sendMessage(new Message(null, CMD_UNBLOCK, unBlockName, 1));
								}
								break;
							case CMD_START_PRIVATE:
								String targetName = (String) message.getContent();
								while (true) {
									try {
										ServerSocket testServerSocket = new ServerSocket(private_port);
										testServerSocket.close();
										break;
									} catch (IOException e) {
										System.out.println("Port" + private_port + " is in use, add 1.");
										private_port++;
										continue;
									}
								}
								if (!mOnlineClientMap.containsKey(targetName)) {
									mClient.sendMessage(new Message(null, CMD_START_PRIVATE, targetName, 2));
								} else {
									mClient.sendMessage(new Message(null, CMD_START_PRIVATE, private_port, 0));
									mOnlineClientMap.get(targetName).sendMessage(new Message(mUser.getUsername(), CMD_START_PRIVATE, private_port, 1));
									private_port++;
								}
								break;
							case CMD_PRIVATE:
								break;
							case CMD_LOGOUT:
								isOnline = false;
								break;
						}
					} catch (ClassCastException e) {
						sendError();
						continue;
					}
				}
				onAfterOffline();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		private void onBeforeOnline() throws IOException, ClassNotFoundException {
			while (!isOnline) {
				Message message = (Message) mInputStream.readObject();
				switch (message.getCommand()) {
					case CMD_LOGIN_USERNAME:
						String username = (String) message.getContent();
						if (mTotalUserMap.containsKey(username)) {
							if (mOnlineClientMap.containsKey(username)) {
								mClient.sendMessage(new Message(null, CMD_LOGIN_USERNAME, null, 1));
							} else {
								mUser = getUserByName(message.getUsername());
								mClient.setUser(mUser);
								mClient.sendMessage(new Message(null, CMD_LOGIN_USERNAME, null, 0));
							}
						} else {
							mClient.sendMessage(new Message(null, CMD_LOGIN_USERNAME, 0, 2));
						}
						break;
					case CMD_LOGIN_PASSWORD:
						String password = (String) message.getContent();
						int responseCode = mUser.login(password, block_duration);
						if (responseCode == 0) {
							mClient.sendMessage(new Message(null, CMD_LOGIN_PASSWORD, mClient.getUser(), responseCode));
							isOnline = true;
							clientGoOnline();
						} else {
							mClient.sendMessage(new Message(null, CMD_LOGIN_PASSWORD, null, responseCode));
						}
						break;
				}
			}
		}

		private void onAfterOffline() throws IOException {
			clientGoOffline();
		}

		private void sendMessage(String targetUsername, String content) throws IOException {
			log(mClient.getUser().getUsername(), CMD_SEND_MESSAGE, content);
			if (!mTotalUserMap.containsKey(targetUsername)) {
				mClient.sendMessage(new Message(null, CMD_SEND_MESSAGE, null, 3));
				return;
			}
			if (getUserByName(targetUsername).getBlackList().contains(mUser.getUsername())) {
				mClient.sendMessage(new Message(null, CMD_SEND_MESSAGE, null, 1));
				return;
			}
			if (mOfflineMessageMap.containsKey(targetUsername)) {
				mClient.sendMessage(new Message(null, CMD_SEND_MESSAGE, null, 2));
				mOfflineMessageMap.get(targetUsername).add(wrapContent(content));
			} else {
				mOnlineClientMap.get(targetUsername).sendMessage(new Message(mUser.getUsername(), CMD_SEND_MESSAGE, wrapContent(content), 0));
			}
		}

		private void sendBroadcast(String content) throws IOException {
			log(mClient.getUser().getUsername(), CMD_BROADCAST, content);
			Message message = new Message(mUser.getUsername(), CMD_BROADCAST, content, 0);
			boolean allDelivered = true;
			for (String username : mOnlineClientMap.keySet()) {
				if (username.equals(mUser.getUsername())) {
					continue;
				}
				if (getUserByName(username).getBlackList().contains(mUser.getUsername())) {
					allDelivered = false;
					continue;
				}
				mOnlineClientMap.get(username).sendMessage(message);
			}
			if (!allDelivered) {
				mClient.sendMessage(new Message(null, CMD_BROADCAST, null, 1));
			}
		}

		private void sendWhoElse() throws IOException {
			log(mClient.getUser().getUsername(), CMD_WHOELSE, null);
			if (mOnlineClientMap.size() == 1) {
				mClient.sendMessage(new Message(null, CMD_WHOELSE, "No one else is online", 1));
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (String username : mOnlineClientMap.keySet()) {
				if (!username.equals(mClient.getUser().getUsername())) {
					sb.append(username).append('\n');
				}
			}
			mClient.sendMessage(new Message(null, CMD_WHOELSE, sb.toString().trim(), 0));
		}

		private void sendWhoElseSince(int time) throws IOException {
			long currTime = System.currentTimeMillis();
			StringBuilder sb = new StringBuilder();
			for (String username : mTotalUserMap.keySet()) {
				if ((currTime - mTotalUserMap.get(username).getLastAliveTime()) <= (time * 1000)) {
					sb.append(username).append('\n');
				}
			}
			if (sb.length() == 0) {
				sb.append("No user.");
			}
			mClient.sendMessage(new Message(null, CMD_WHOELSE_SINCE, sb.toString().trim(), 0));
		}

		private void clientGoOnline() throws IOException {
			String username = mUser.getUsername();
			List<String> offlineMessges = mOfflineMessageMap.get(username);
			mOfflineMessageMap.remove(username);
			StringBuilder sb = new StringBuilder();
			for (String message : offlineMessges) {
				sb.append(message).append('\n');
			}
			mOnlineClientMap.put(username, mClient);
			mClient.sendMessage(new Message(null, CMD_SEND_MESSAGE, sb.toString(), 0));
			String onlineBroadcastContent = mUser.getUsername() + " logged in";
			sendBroadcast(onlineBroadcastContent);
		}

		private void clientGoOffline() throws IOException {
			if (System.currentTimeMillis() - mUser.getLastAliveTime() > timeout * 1000) {
				mClient.sendMessage(new Message(null, CMD_LOGOUT, null, 1));
			}
			String username = mUser.getUsername();
			mOnlineClientMap.remove(username);
			mOfflineMessageMap.put(username, new ArrayList<>());
			String offlineBroadcastContent = mUser.getUsername() + " logged out";
			sendBroadcast(offlineBroadcastContent);
		}

		private void sendError() {
			mClient.sendMessage(new Message(null, CMD_ERROR, null, 0));
		}

		private String wrapContent(String content) {
			return mUser.getUsername() + ": " + content;
		}

		private String wrapContent(Object content) {
			return mUser.getUsername() + ": " + content.toString();
		}

		private Message wrapMessage(String commmand, String content) {
			return new Message(mUser.getUsername(), commmand, content, 0);
		}

	}


}
