package com.socker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println(("服务端在9999端口监听"));
        Socket socket = serverSocket.accept();

        System.out.println(socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        //设置结束标志
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readlen = 0;
        while ((readlen = inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readlen));
        }
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("客户端退出了");
    }
}
