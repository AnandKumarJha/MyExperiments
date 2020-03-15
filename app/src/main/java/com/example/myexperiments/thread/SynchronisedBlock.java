package com.example.myexperiments.thread;

import java.util.ArrayList;
import java.util.Random;

public class SynchronisedBlock {

    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    Random random = new Random();
    Object object1 = new Object();
    Object object2 = new Object();

    public static void main(String[] args) {
        SynchronisedBlock synchronisedBlock = new SynchronisedBlock();
        synchronisedBlock.process();
    }

    public void process() {

        System.out.println("Starting ....");
        long start = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    addToList1();
                    addToList2();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    addToList1();
                    addToList2();
                }
            }
        });
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time taken " + (System.currentTimeMillis() - start));
        System.out.println("List 1 : " + list1.size() + " List 2 : " + list2.size());
    }

    public void addToList1() {
        synchronized (object1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public synchronized void addToList2() {
        synchronized (object2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

}
