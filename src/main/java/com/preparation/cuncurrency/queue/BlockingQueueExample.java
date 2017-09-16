package com.preparation.cuncurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vlados on 9/16/2017.
 */
public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

        Thread sender = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    blockingQueue.put(i);
                    System.out.println("put value " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread receiver = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);

                    Integer value = blockingQueue.take();
                    System.out.println("get value " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        sender.start();
        receiver.start();
    }
}
