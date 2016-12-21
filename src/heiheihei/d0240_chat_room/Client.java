package heiheihei.d0240_chat_room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String name;
    private boolean flag = true;
    private String host;
    private int port;
    private long startTime;

    public static void main(String[] args) {
        System.out.print("target chatroom host: ");
        Scanner scan = new Scanner(System.in);
        String host = scan.next();
        int port = -1;
        while (port == -1) {
            System.out.print("target chatroom port: ");
            try {
                port = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.print("your input is invalid.");
            }
        }
        new Client(host, port).startUp();
    }

    /**
     * client constructor
     * @param host - host of the client
     * @param port - port of the client
     */
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        this.startTime = System.currentTimeMillis();
    }

    /**
     * start up a new client
     */
    private void startUp() {
        Scanner scan = new Scanner(System.in);
        System.out.print("name: ");
        name = scan.next();
        BufferedReader sbr = null;
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(name);
            sbr = new BufferedReader(new InputStreamReader(System.in));
            new Thread(new ClientThread()).start();
            String str = null;
            while (flag && (str = sbr.readLine()) != null) {
                if (!flag) break;
                if (str.equals("-time")) {
                    long time = System.currentTimeMillis() - startTime;
                    int minute = (int) (time / 1000000);
                    int second = (int) (time / 1000);
                    System.out.print("Running time:   client" + minute + "m" + second + "s");
                }
                writer.println(str);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
            System.out.println("wrong host or port.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (sbr != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * receive message from server
     */
    private void receive() {
        try {
            String rs = reader.readLine();
            if (rs.equalsIgnoreCase("quit")) {
                flag = false;
                System.out.println("点击回车退出");
            }
            System.out.println(rs);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e1) {
            return;
        }
    }

    /**
     * client thread
     */
    private class ClientThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!flag) break;
                receive();
            }
        }

    }

}