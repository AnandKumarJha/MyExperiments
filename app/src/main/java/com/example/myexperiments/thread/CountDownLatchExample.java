package com.example.myexperiments.thread;

import java.util.concurrent.CountDownLatch;

class DevTeam implements Runnable {
    CountDownLatch mCountDownLatch;
    String mThreadName;

    DevTeam(CountDownLatch countDownLatch, String threadName) {
        mCountDownLatch = countDownLatch;
        mThreadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(mThreadName + " started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mThreadName + " stopped.");

        mCountDownLatch.countDown();
    }
}

class QaTeam implements Runnable {
    CountDownLatch mCountDownLatch;
    String mThreadName;

    QaTeam(String threadName) {
        mThreadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(mThreadName + " started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mThreadName + " stopped.");
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        DevTeam devTeam1 = new DevTeam(countDownLatch, "Dev 1");
        DevTeam devTeam2 = new DevTeam(countDownLatch, "Dev 2");
        Thread t1Dev = new Thread(devTeam1);
        Thread t2Dev = new Thread(devTeam2);

        t1Dev.start();
        t2Dev.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        QaTeam qaTeam = new QaTeam("QA Team");
        Thread tQa = new Thread(qaTeam);
        tQa.start();
    }
}
