package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ComplexCalculationTask implements Runnable {
    private int taskId;

    public ComplexCalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started");
        try {
            long result = 0;
            for (int i = 0; i < 1000000; i++) {
                result += i;
            }
            System.out.println("Task " + taskId + " completed. Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            Runnable task = new ComplexCalculationTask(i);
            executor.submit(task);
        }
        executor.shutdown();
    }
}
