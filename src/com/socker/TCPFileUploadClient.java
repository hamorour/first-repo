package com.socker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath = "D:\\桌面\\image\\1.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

    }
}
