package com.preparation.cuncurrency.simple.thread;

/**
 * Description of class HelloWorldThread
 *
 * @created: 9/13/2017
 */
public class HelloWorldThread extends Thread {

    public HelloWorldThread() {
    }

    public HelloWorldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hello world");
        System.out.println(getName());
    }
}

class Main {
    public static void main(String[] args) {
        Thread helloWorldThread = new HelloWorldThread("helloWorldThread");

        Thread anonymousThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Running anonymous thread...");
            System.out.println(Thread.currentThread().getName());
        });

        anonymousThread.setName("anonymousThread");

        TestRunnable testRunnable = new TestRunnable();
        Thread testRunnableThread = new Thread(testRunnable, "testRunnableThread");

        anonymousThread.start();
        helloWorldThread.start();
        testRunnableThread.start();
    }
}


class TestRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Runnable working....");
        System.out.println(Thread.currentThread().getName());
    }
}