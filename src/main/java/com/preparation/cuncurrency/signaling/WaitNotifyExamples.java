package com.preparation.cuncurrency.signaling;

/**
 * Description of class WaitNotifyExamples
 *
 * @created: 9/14/2017
 */
public class WaitNotifyExamples {
    public static void main(String[] args) {
        Signal signal = new Signal();
        Runnable waitRunnable = new WaitRunnable(signal);
        Runnable notifyRunnable = new NotifyRunnable(signal);
        Runnable notifyAllRunnable = new NotifyAllRunnable(signal);

        Thread wr1 = new Thread(waitRunnable, "wr-1");
        Thread wr2 = new Thread(waitRunnable, "wr-2");
        Thread wr3 = new Thread(waitRunnable, "wr-3");
        Thread wr4 = new Thread(waitRunnable, "wr-4");

        Thread n1 = new Thread(notifyRunnable, "n-1");

        Thread na1 = new Thread(notifyAllRunnable, "na-1");

        wr1.start();
        wr2.start();
        wr3.start();
        wr4.start();

        n1.start();

        na1.start();
    }
}

class Signal {
    public synchronized void doWait() {
        try {
            System.out.println(Thread.currentThread().getName() + " before wait");
            this.wait();
            System.out.println(Thread.currentThread().getName() + " after wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doNotify() {
        System.out.println("notify");
        this.notify();
    }

    public synchronized void doNotifyAll() {
        System.out.println("notifyAll");
        this.notifyAll();
    }
}

class WaitRunnable implements Runnable {

    private Signal signal;

    public WaitRunnable(Signal signal) {
        this.signal = signal;
    }

    @Override
    public void run() {
        signal.doWait();
    }
}

class NotifyRunnable implements Runnable {

    private Signal signal;

    public NotifyRunnable(Signal signal) {
        this.signal = signal;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signal.doNotify();
    }
}

class NotifyAllRunnable implements Runnable {

    private Signal signal;

    public NotifyAllRunnable(Signal signal) {
        this.signal = signal;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signal.doNotifyAll();
    }
}