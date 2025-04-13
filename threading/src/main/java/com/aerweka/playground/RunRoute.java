package com.aerweka.playground;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunRoute extends Thread {
    private static int total;
    private int n;

    public RunRoute(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Hello from thread " + n);
        total++;
    }

    public static void runRoute(int n) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < n; i++) {
            newSingleThreadExecutor.execute(new RunRoute(i));
        }

        newSingleThreadExecutor.shutdown();

        try {
            newSingleThreadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("Total: " + total);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
