package com.example.myexperiments.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer implements Runnable {
    private Queue<Integer> sharedQueue;
    private Random random = new Random();
    private int data;

    Producer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                if (sharedQueue.size() > 5) {
                    System.out.println("Producer is waiting to consume product by consumer");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                data = random.nextInt(100);
                sharedQueue.add(data);
                System.out.println("Data produced : " + data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedQueue.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    Queue<Integer> sharedQueue;

    Consumer(Queue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                if (sharedQueue.isEmpty()) {
                    System.out.println("Consumer is waiting to produce product by producer");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int data = sharedQueue.poll();
                System.out.println(data);
                sharedQueue.notify();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);

        Thread tProducer = new Thread(producer);
        Thread tConsumer = new Thread(consumer);

        tConsumer.start();
        tProducer.start();
    }
}
