package com.ticket;

public class ThreadMethon {
    public static void main(String[] args) throws InterruptedException{
        T t = new T();
        t.start();

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程吃了" + i + "包子");
            if(i==5){
                System.out.println("让子线程先吃");
                //t.join();
                t.yield();
                System.out.println("子线程吃完了");
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程吃了" + i + "包子");
        }
    }
}
