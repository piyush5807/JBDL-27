package com.example;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Main {


    // common fork join pool contains - (n - 1) daemon thread + 1 main thread

    public static int square(int num){
        System.out.println("In calculate fn, thread is " + Thread.currentThread().getName() +
                ", isDaemon " + Thread.currentThread().isDaemon());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num * num + 1;
    }

    public static CompletableFuture<Integer> calculate(int num){
        return CompletableFuture.supplyAsync(() -> square(num));
    }

    public static void run(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In run" + i + " method thread is " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // q1. You are a number, you need to the square + 1 of this number
        int n = 10;


        CompletableFuture<Integer> result = calculate(n);
        CompletableFuture<Integer> result2 = calculate(n + 2);


        result.get(); // blocking call
//        try not to use get with completable future

        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        result.thenApply(num -> {
            System.out.println("In apply method: thread is " + Thread.currentThread().getName());
            return num / 2;
                })
                .thenAccept(num -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("In accept method: thread is " + Thread.currentThread().getName());
                    System.out.println(num);
                }).thenRun(() -> run(1))
                .thenRun(() -> run(2))
                .thenRun(() -> run(3))
                .thenRun(() -> run(4))
                .thenRun(() -> run(5));

        // Here the boss is saying let me know once your task is done, I have some other tasks in the pipeline for you

        System.out.println("In the ending of main fn");

        int num = 100;
        BigInteger res = BigInteger.ONE;
        for(int i = 2; i < num; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }

        System.out.println(res);


        Thread.sleep(6000);

    }
}
