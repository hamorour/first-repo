package com.ticket;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException{
        T0 t = new T0();
        System.out.println(t.getName()+ " 状态 " +t.getState());

        t.start();

        while (Thread.State.TERMINATED != t.getState()){
            for (int i = 0; i < 10; i++) {
                System.out.println(t.getName()+ " 状态 " +t.getState());
                Thread.sleep(1000);
            }
           break;
        }

        System.out.println(t.getName()+ " 状态 " +t.getState());

    }
}

class T0 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
