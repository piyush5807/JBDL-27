package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {

    public static int calculate(int num){
        System.out.println("In calculate fn, thread is " + Thread.currentThread().getName() +
                ", isDaemon " + Thread.currentThread().isDaemon());

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num * num + 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int n = 10;

        Future<Integer> future;

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        future = executorService.submit(() -> calculate(n));

        int result = future.get(); // This is a blocking call
        // Here the boss is waiting for the employee to complete the task
        // so that the boss can proceed further

        // wait and notify

        System.out.println("In main thread, result by 2" + (result / 2));

        System.out.println("This is the ending of main fn");
    }
}
