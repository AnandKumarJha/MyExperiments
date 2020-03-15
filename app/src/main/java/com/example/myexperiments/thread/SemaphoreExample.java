package com.example.myexperiments.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Connection {
    private static final Connection INSTANCE = new Connection();
    private int conCount = 0;

    private Semaphore semaphore = new Semaphore(10, true);

    private Connection() {

    }

    public static Connection getInstance() {
        return INSTANCE;
    }

    public void connect() {
        try {
            semaphore.acquire();

            synchronized (this) {
                conCount++;
                System.out.println("Number of connections " + conCount);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                conCount--;
                System.out.println("Number of connections " + conCount);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService executorService = null;

        try {
            executorService = Executors.newCachedThreadPool();

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            };

            for (int i = 0; i < 300; i++) {
                executorService.submit(runnable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }


        //To check current num of permits of the semaphore
        Semaphore semaphore = new Semaphore(1);

        System.out.println("Current number of permits : " + semaphore.availablePermits()); // will print 1 as passed in constructor

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current number of permits : " + semaphore.availablePermits()); // will print 0 as it is aquired by the thread

        semaphore.release();
        System.out.println("Current number of permits : " + semaphore.availablePermits()); // will print 1 again as acquired permission has been released
    }
}