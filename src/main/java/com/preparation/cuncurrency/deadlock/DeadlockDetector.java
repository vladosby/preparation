package com.preparation.cuncurrency.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by vlados on 9/16/2017.
 */
public class DeadlockDetector {
    public static void detectDeadlock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        int deadlockedThreads = threadIds != null ? threadIds.length : 0;
        System.out.println("Number of deadlocked threads: " + deadlockedThreads);

        for (int i = 0; i < threadIds.length; i++) {
            printThreadNameById(threadIds[i]);
        }
    }

    private static void printThreadNameById(long id) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getId() == id) {
                System.out.println("Deadlocked thread: " + t.getName());
            }
        }
    }
}
