package com.preparation.cuncurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by vlados on 9/16/2017.
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        Thread sender = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    semaphore.acquire();
                    System.out.println("acquire " + i);
                }
            } catch (InterruptedException e) {
            }
        });

        Thread receiver = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                semaphore.release();
                System.out.println("received " + i);
            }
        });

        sender.start();
        receiver.start();
    }
}
