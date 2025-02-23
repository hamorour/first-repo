package com.ticket;

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        SellTicket03 sellTicket02 = new SellTicket03();
        new Thread(sellTicket02).start();//第一个线程窗口
        new Thread(sellTicket02).start();//第二个线程窗口
        new Thread(sellTicket02).start();//第三个线程窗口
    }
}

class SellTicket01 extends Thread {
    private int ticketNum = 100;//让多个线程共享ticketNum
    @Override
    public void run() {
        while (true){
            if(ticketNum<=0){
                System.out.println("售票结束...");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                     "  剩余票数 = " +(--ticketNum));


        }
    }
}


class SellTicket02 implements Runnable{
    private int ticketNum = 100;//让多个线程共享ticketNum
    @Override
    public void run() {
        while (true){
            if(ticketNum<=0){
                System.out.println("售票结束...");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    "  剩余票数 = " +(--ticketNum));


        }
    }
}

class SellTicket03 implements Runnable{
    private int ticketNum = 100;//让多个线程共享ticketNum
    private boolean loop = true;
    public synchronized void sell(){//同步方法，在同一个时刻只能有一个线程操作run方法
        if(ticketNum<=0){
            loop=false;
            System.out.println("售票结束...");

            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                "  剩余票数 = " +(--ticketNum));

        return;
    }
    @Override
    public  void run() {
        while (loop){
            sell();

        }
    }
}
