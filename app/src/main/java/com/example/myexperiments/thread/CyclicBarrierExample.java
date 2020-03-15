package com.example.myexperiments.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class PassangerThread extends Thread {
    int mDuration;
    CyclicBarrier mCyclicBarrier;
    String mThreadName;

    PassangerThread(int duration, CyclicBarrier cyclicBarrier, String threadName) {
        mDuration = duration;
        mCyclicBarrier = cyclicBarrier;
        mThreadName = threadName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(mDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mThreadName + " is arrived.");

        try {
            int await = mCyclicBarrier.await();

            if (await == 0) {
                System.out.println("Four passangers has arrived and now cab is about to go.");
            }

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mThreadName + " is finished.");
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        PassangerThread pt1 = new PassangerThread(1000, cyclicBarrier, "Thread 1");
        PassangerThread pt2 = new PassangerThread(2000, cyclicBarrier, "Thread 2");
        PassangerThread pt3 = new PassangerThread(3000, cyclicBarrier, "Thread 3");
        PassangerThread pt4 = new PassangerThread(4000, cyclicBarrier, "Thread 4");

        PassangerThread pt5 = new PassangerThread(1000, cyclicBarrier, "Thread 5");
        PassangerThread pt6 = new PassangerThread(2000, cyclicBarrier, "Thread 6");
        PassangerThread pt7 = new PassangerThread(3000, cyclicBarrier, "Thread 7");
        PassangerThread pt8 = new PassangerThread(4000, cyclicBarrier, "Thread 8");

        pt1.start();
        pt2.start();
        pt3.start();
        pt4.start();

        pt5.start();
        pt6.start();
        pt7.start();
        pt8.start();
    }
}
