package com.example.myexperiments.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable {
    int id;

    WorkerThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id + " Started...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " Stopped...");
    }
}

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new WorkerThread(i));
        }
        threadPoolExecutor.shutdown();

        System.out.println("All task submitted.");

        try {
            threadPoolExecutor.awaitTermination(25000, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All task completed.");
    }

}
