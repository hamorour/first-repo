package com.draw;

import java.security.spec.ECParameterSpec;

public class CupNum {
    public static void main(String[] args) throws InterruptedException{
        Cat cat = new Cat();
        cat.start();
        System.out.println("主线程继续执行"+Thread.currentThread().getName());
        for (int i = 0; i <80; i++) {
            System.out.println("主线程 i = "+i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("miaomiao,I am cat"+times+"\t线程名称 "+Thread.currentThread().getName());
            ++times;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times==8){
                break;
            }
        }
    }
}
