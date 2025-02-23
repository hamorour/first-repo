package com.socker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class A {
    public static void main(String[] args) throws IOException {
        //接收端
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("接收端A 等待接收数据...");
        socket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data =datagramPacket.getData();
        String s = new String(data, 0, length);

        System.out.println(s);

        byte[] bytes = "好的，明天见".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("172.30.208.1"), 9998);
        socket.send(packet);

        socket.close();
        System.out.println("A端退出");

    }
}
