package com.mrliuxia.heiheihei.d0240_f;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Poker on 2016/12/15.
 */
public class ChatRoomClient {

    private static final int PORT = 12156;
    private static final int BUFFER_CAPACITY = 1024;
    private static final String USER_EXIST = "error: user name exists, please change one";
    private static final String USER_SPLITER = " ## ";

    private Selector selector;
    private SocketChannel channel;
    private Charset charset = Charset.forName("UTF-8");
    private String name = "";

    public static void main(String[] args) throws IOException {
        new ChatRoomClient().init();
    }

    private void init() throws IOException {
        selector = Selector.open();
        channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        Thread chatThread = new ClientThread();
        chatThread.start();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if ("".equals(line)) {
                continue;
            }
            if ("".equals(name)) {
                name = line;
                line = name + USER_SPLITER;
            } else {
                line = name + USER_SPLITER + line;
            }
            channel.write(charset.encode(line));
        }

    }

    private class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    int readyChannels = selector.select();
                    if (readyChannels == 0) {
                        continue;
                    }
                    Set selectedKeys = selector.selectedKeys();
                    Iterator keyIterator = selectedKeys.iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = (SelectionKey) keyIterator.next();
                        keyIterator.remove();
                        doBussiness(key);
                    }
                }
            } catch (IOException ioe) {

            }
        }

        private void doBussiness(SelectionKey key) throws IOException {
            if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
                String content = "";
                while (channel.read(buffer) > 0) {
                    buffer.flip();
                    content += charset.decode(buffer);
                }
                if (USER_EXIST.equals(content)) {
                    name = "";
                }
                System.out.println(content);
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }

}
