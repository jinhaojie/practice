package com.jin.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchThread {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        final Service service = new Service(latch);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                service.exec();
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("main thread await. ");
        latch.await();
        System.out.println("main thread finishes await. ");
    }
}

 class Service {
    private CountDownLatch latch;

    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    public void exec() {
        try {
            System.out.println(Thread.currentThread().getName() + " execute task. ");
            sleep(2);
            System.out.println(Thread.currentThread().getName() + " finished task. ");
        } finally {
            latch.countDown();
            latch.countDown();
            latch.countDown();
        }
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}