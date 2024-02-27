/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author thanos
 */
public class Server01 {
    private final int port;
    private final boolean isServer;
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private Selector selector;
    public PriorityBlockingQueue<String> inQueue = new PriorityBlockingQueue<>();
    

    public Server01(int port, boolean isServer) {
        this.port = port;
        this.isServer = isServer;
    }

    public void start() throws InterruptedException {
        try {
            selector = Selector.open();
            if (isServer) {
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(new InetSocketAddress(port));
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                System.out.println("Server started on port " + port);
            } else {
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                socketChannel.connect(new InetSocketAddress("localhost", port));
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
                System.out.println("Client connected to port " + port);
            }

            while (true) {
                selector.select();
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable() && isServer) {
                        handleAccept(key);
                    } else if (key.isConnectable() && !isServer) {
                        handleConnect(key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    } else if (key.isWritable()) {
                        handleWrite(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selector != null) selector.close();
                if (serverSocketChannel != null) serverSocketChannel.close();
                if (socketChannel != null) socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Client connected: " + socketChannel.getRemoteAddress());
    }

    private void handleConnect(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        if (socketChannel.finishConnect()) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("Connection established to server: " + socketChannel.getRemoteAddress());
        } else {
            System.err.println("Connection failed.");
            socketChannel.close();
        }
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);
        if (bytesRead == -1) {
            System.out.println("Client disconnected: " + socketChannel.getRemoteAddress());
            socketChannel.close();
            return;
        }
        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        String message = new String(data);
        System.out.println("Received from client " + socketChannel.getRemoteAddress() + ": " + message);
    }
    private void handleWrite(SelectionKey key ) throws IOException, InterruptedException{
        SocketChannel s;
        if(key.isWritable() && inQueue.size() > 0){
            s = (SocketChannel) key.channel();
            
            for(int i = 0; i < inQueue.size(); i++){
                String temp = inQueue.remove();
                byte [] byteArray = Base64.getDecoder().decode(temp);
                ByteBuffer buffer = ByteBuffer.allocate(byteArray.length + 8);
                buffer.put(byteArray);
                buffer.flip();
                s.write(buffer);
            }
        }
        Thread.sleep(10);
    }
}
