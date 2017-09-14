package com.preparation.cuncurrency.signaling;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description of class WaitNotifyWithFlag
 *
 * @created: 9/14/2017
 */
public class WaitNotifyWithFlag {
    public static void main(String[] args) {
        Signal2 signal = new Signal2();
        Runnable waitRunnable = new WaitRunnable2(signal);
        Runnable notifyRunnable = new NotifyRunnable2(signal);

        Thread n1 = new Thread(notifyRunnable, "n-1");

        Thread wr1 = new Thread(waitRunnable, "wr-1");

        n1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wr1.start();

    }
}

class Signal2 {
    public boolean isCalled = false;

    public synchronized void doWait() {
        System.out.println(Thread.currentThread().getName() + " before wait");

        while (!isCalled) {
            try {
                this.wait();
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " after wait");

        isCalled = false;
    }

    public synchronized void doNotify() {
        System.out.println("notify");
        isCalled = true;
        this.notify();
    }
}

class WaitRunnable2 implements Runnable {

    private Signal2 signal;

    public WaitRunnable2(Signal2 signal) {
        this.signal = signal;
    }

    @Override
    public void run() {
        signal.doWait();
    }
}

class NotifyRunnable2 implements Runnable {

    private Signal2 signal;

    public NotifyRunnable2(Signal2 signal) {
        this.signal = signal;
    }

    @Override
    public void run() {
        signal.doNotify();
    }
}
