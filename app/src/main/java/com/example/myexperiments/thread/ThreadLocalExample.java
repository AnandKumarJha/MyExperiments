package com.example.myexperiments.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final ThreadLocalExample threadLocalExample = new ThreadLocalExample();


        for (int i = 0; i < 1000; i++) {
            final int a = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int duration = random.nextInt(400) + 200;
                    try {
                        Thread.sleep(duration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Duration : " + duration + " Number : " + a + " " + threadLocalExample.getBirthDate(a));
                }
            });
        }
    }

    public String getBirthDate(int userId) {
        //this is returning dummy date of birth for a given user
        String userBirthDate = "DOB of " + userId;
        ThreadSafeFormatter.simpleDateFormatThreadLocal.get().format("04-07-2000");
        return userBirthDate;
    }

}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd-mm-yyyy", new Locale("US"));
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}
