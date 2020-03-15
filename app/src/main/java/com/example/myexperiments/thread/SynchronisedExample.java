package com.example.myexperiments.thread;

public class SynchronisedExample {

    private int count = 0;

    public static void main(String[] args) {
        SynchronisedExample synchronisedExample = new SynchronisedExample();
        synchronisedExample.doWork();
    }

    public synchronized void increment(){
        count++;
    }

    private void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count = " + count);
    }

}
