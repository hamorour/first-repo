package com.tankegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame extends JFrame {

    MyPanel mp =null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        new TankGame();
    }

    public TankGame() throws HeadlessException {
        System.out.println("请输入选择 1：新游戏  2：继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        //将mp放入线程并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //在JFrame中添加相关的窗口处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
