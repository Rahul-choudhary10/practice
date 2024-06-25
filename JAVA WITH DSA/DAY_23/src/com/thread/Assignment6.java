package com.thread;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Assignment6 {

    public static void main(String[] args) throws IOException {
        int maxNumber = 100;
        String fileName = "prime_numbers.txt";
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        CompletableFuture<List<Integer>> primeFuture = CompletableFuture.supplyAsync(() -> {
            return calculatePrimeNumbers(maxNumber, executor);
        }, executor);
        primeFuture.thenAcceptAsync(primeNumbers -> {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (int prime : primeNumbers) {
                    writer.write(prime + "\n");
                }
                System.out.println("Prime numbers are written to " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executor);
        executor.shutdown();
    }

    public static List<Integer> calculatePrimeNumbers(int maxNumber, ExecutorService executor) {
        List<Integer> primes = new ArrayList<>();
        for (int number = 2; number <= maxNumber; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
