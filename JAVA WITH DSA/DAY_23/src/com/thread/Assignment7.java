package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

// Immutable class for sharing data between threads
final class ImmutableData {
    private final String data;

    public ImmutableData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ImmutableData immutableData = new ImmutableData("Hello, Immutable!");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        };
        Runnable immutableDataTask = () -> {
            System.out.println(Thread.currentThread().getName() + " accessing immutable data: " + immutableData.getData());
        };
        executor.submit(incrementTask);
        executor.submit(decrementTask);
        executor.submit(immutableDataTask);
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Final count: " + counter.getCount());
    }
}
