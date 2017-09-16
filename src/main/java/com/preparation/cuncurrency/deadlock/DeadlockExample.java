package com.preparation.cuncurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vlados on 9/16/2017.
 */
public class DeadlockExample {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("acquired lock1 by thread " + Thread.currentThread().getName());
                lock2.lock();
                System.out.println("acquired lock2 by thread " + Thread.currentThread().getName());
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }, "tread-1");

        Thread thread2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println("acquired lock1 by thread " + Thread.currentThread().getName());
                lock1.lock();
                System.out.println("acquired lock2 by thread " + Thread.currentThread().getName());
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }, "tread-2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeadlockDetector.detectDeadlock();
    }
}


