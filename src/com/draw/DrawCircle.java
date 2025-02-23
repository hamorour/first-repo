package com.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        this.add(mp);

        this.setBounds(5,5,300,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.fillOval(10,10,100,100);
    }
}
