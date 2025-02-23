package com.socker;

import java.io.IOException;
import java.net.*;

public class B {
    public static void main(String[] args) throws IOException {
        //发送端
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据装包
        byte[] bytes = "hello 明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.30.208.1"), 9999);
        socket.send(packet);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("接收端B 等待接收数据...");
        socket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data =datagramPacket.getData();
        String s = new String(data, 0, length);

        System.out.println(s);
        socket.close();
        System.out.println("B端退出");
    }
}
