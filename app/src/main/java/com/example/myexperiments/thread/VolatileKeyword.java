package com.example.myexperiments.thread;


import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean isToRun = true;
    int i = 0;

    @Override
    public void run() {
        while (isToRun) {
            System.out.println(i++);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown(boolean isToRun){
        this.isToRun = isToRun;
    }
}

public class VolatileKeyword {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Press enter to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Stopped");
        processor.shutDown(false);
    }

}
