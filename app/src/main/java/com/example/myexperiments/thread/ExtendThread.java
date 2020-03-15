package com.example.myexperiments.thread;

class Runner1 extends Thread{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExtendThread {
    public static void main(String[] args){
        Runner1 runner1 = new Runner1();
        runner1.start();
    }
}
