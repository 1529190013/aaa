package com.zgw;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class NioCliet {

    public static void main(String[] args) {
        System.out.println("开启NIO客户端............");
        try {
            SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            byteBuffer.flip();
            byteBuffer.put(new Date().toString().getBytes());
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class NioServer{

        public static void main(String[] args) {
            try {
                System.out.println("NIO服务端启动");
                ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.bind(new InetSocketAddress(8080));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
