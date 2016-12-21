package heiheihei.d0240_chat_room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {

    private long startTime;
    private List<ServerThread> clients = null;
    private Set<String> clientNames;

    public static void main(String[] args) {
        new Server().startup();
    }

    /**
     * server constructor
     * init fields
     */
    public Server() {
        startTime = System.currentTimeMillis();
        clientNames = new HashSet<>();
    }

    /**
     * start up a new server
     */
    private void startup() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(12345);
            System.out.println("Server[" + server.getInetAddress().getCanonicalHostName() + ":"
                    + server.getLocalPort() + "] started");
            clients = new ArrayList<ServerThread>();
            while (true) {
                socket = server.accept();
                ServerThread serverThread = new ServerThread(socket, startTime);
                new Thread(serverThread).start();
            }
        } catch (BindException e1) {
            System.out.println("port has been used");
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * server thread
     */
    private class ServerThread implements Runnable {
        private Socket socket = null;
        private BufferedReader reader;
        private PrintWriter writer;
        private String name;
        private boolean flag = true;
        private long startTime;

        public ServerThread(Socket socket, long startTime) throws IOException {
            this.socket = socket;
            this.startTime = startTime;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String str = reader.readLine();
            while (clientNames.contains(str)) {
                writer.print("this name has been used.\nname:");
                str = reader.readLine();
            }
//            if (!clientNames.contains(str)) {
            clientNames.add(str);
            name = str + "[" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]";
            clients.add(this);
            send(name + " enter the chat room.");
//            } else {
//            }
        }

        @Override
        public void run() {
            try {
                while (flag) {
//                    if (!flag) break;
                    receive();
                }
            } catch (SocketException e) {
                stop();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * send message to clients
         *
         * @param msg
         */
        private void send(String msg) {
            System.out.println(msg);
            for (ServerThread st : clients) {
                st.writer.println(msg);
            }
        }

        /**
         * receive message from clients
         *
         * @throws IOException
         */
        private void receive() throws IOException {
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (str.equalsIgnoreCase("-time")) {
                    long time = System.currentTimeMillis() - startTime;
                    int minute = (int) (time / 1000000);
                    int second = (int) (time / 1000);
                    writer.println("  server " + minute + "m" + second + "s");
                    continue;
                }
                if (str.equalsIgnoreCase("-ip")) {
                    writer.println("ip: " + socket.getInetAddress().getHostAddress());
                    continue;
                }
                if (str.equalsIgnoreCase("-port")) {
                    writer.println("port: " + socket.getPort());
                    continue;
                }
                if (str.equalsIgnoreCase("-num")) {
                    writer.println("connect num: " + clients.size());
                    continue;
                }
                if (str.equalsIgnoreCase("quit")) {
                    stop();
                    writer.println("disconnect");
                    break;
                }

                send(name + ":" + str);
            }
        }

        /**
         * stop the server thread
         */
        private void stop() {
            clients.remove(this);
            flag = false;
            send(name + " leave the chat room.");
        }

    }
}
