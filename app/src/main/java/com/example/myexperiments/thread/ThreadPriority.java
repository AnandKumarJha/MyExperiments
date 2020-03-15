package com.example.myexperiments.thread;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Name : " + Thread.currentThread().getName() + " Count : " + i + " Priority : " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPriority {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "T1");
        Thread t2 = new Thread(myRunnable, "T2");
        Thread t3 = new Thread(myRunnable, "T3");

        t1.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

}
