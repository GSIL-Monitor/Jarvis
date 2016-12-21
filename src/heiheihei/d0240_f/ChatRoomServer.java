package heiheihei.d0240_f;

import com.sun.org.apache.bcel.internal.generic.MethodGen;
import com.sun.org.apache.xml.internal.resolver.Resolver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Poker on 2016/12/15.
 */
public class ChatRoomServer {

    private static final int PORT = 12156;
    private static final String USER_EXIST = "error: user name exists, please change one";
    private static final String USER_SPLITER = " ## ";
    private static final int BUFFER_CAPACITY = 1024;

    private Set<String> userSet = new HashSet<>();
    private Selector selector = null;
    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        new ChatRoomServer().init();
    }

    private void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("localhost", PORT));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server is listening now...");
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
                doBussiness(server, key);
            }
        }
    }

    private void doBussiness(ServerSocketChannel server, SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            SocketChannel channel = server.accept();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
            key.interestOps(SelectionKey.OP_ACCEPT);
            System.out.println("Server is listening from client: " + channel.getRemoteAddress());
            channel.write(charset.encode("Please input your name:"));
        }
        if (key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            StringBuilder content = new StringBuilder();
            try {
                while (channel.read(buffer) > 0) {
                    buffer.flip();
                    content.append(charset.decode(buffer));
                }
                System.out.println("Server is listening from client " + channel.getRemoteAddress());
                System.out.println("  data rev: " + content);
                key.interestOps(SelectionKey.OP_READ);
            } catch (IOException ioe) {
                key.cancel();
                if (key.channel() != null) {
                    key.channel().close();
                }
            }
            if (content.length() > 0) {
                String[] arrayContent = content.toString().split(USER_SPLITER);
//                if (arrayContent == null || arrayContent.length < 1) {
//                    return;
//                }
                if (arrayContent != null && arrayContent.length == 1) {
                    String name = arrayContent[0];
                    if (userSet.contains(name)) {
                        channel.write(charset.encode(USER_EXIST));
                    } else {
                        userSet.add(name);
                        int onlineNum = getOnlineNum(selector);
                        String msg = "Welcome " + name + " to chat room. Online num: " + onlineNum;
                        broadcast(selector, null, msg);
                    }
                } else if (arrayContent != null && arrayContent.length > 1) {
                    String name = arrayContent[0];
                    String msg = content.substring(name.length() + USER_SPLITER.length());
                    msg = name + ": " + msg;
                    if (userSet.contains(name)) {
                        broadcast(selector, channel, msg);
                    }
                }
            }
        }
    }

    // TODO: 2016/12/15 remove selector
    private void broadcast(Selector currSelector, SocketChannel currChannel, String content) throws IOException {
        for (SelectionKey key : currSelector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != currChannel) {
                SocketChannel channel = (SocketChannel) targetChannel;
                channel.write(charset.encode(content));
            }
        }
    }

    public int getOnlineNum(Selector currSelector) {
        int count = 0;
        for (SelectionKey key : currSelector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel) {
                count++;
            }
        }
        return count;
    }

}
