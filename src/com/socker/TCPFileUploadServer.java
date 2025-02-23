package com.socker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket();
        System.out.println("服务端在8888端口监听");
        Socket socket = serverSocket.accept();
    }
}
