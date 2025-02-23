package com.socker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端："+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readlen = 0;
        while ((readlen = inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readlen));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
