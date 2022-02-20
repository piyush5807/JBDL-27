package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FactorialExecutor {

  public static void main(String[] args) throws InterruptedException {


      System.out.println(Runtime.getRuntime().availableProcessors());

      // 20 - 20 threads
      // 20 - 8 threads

    List<Integer> al =
        Arrays.asList(10000, 20000, 30000, 50000, 23000, 56000, 45000, 50000, 70000, 48000, 54000);

//        List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    //    long start = System.currentTimeMillis();

      // 1. faster than thread approach
      // 2. slower than that
      // 3. similar to that
      // 4. Don't know
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    List<Future<BigInteger>> futures = new ArrayList<>();

    long start = System.currentTimeMillis();

    al.stream()
            .forEach(num -> {
                    futures.add(executorService.submit(() -> calculate(num)));
            });

    futures.stream().forEach(future -> {
        try {
            BigInteger RESULT = future.get();
            System.out.println(RESULT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    });

    long end = System.currentTimeMillis();

    System.out.println("time taken is: " + (end - start));

//    executorService.awaitTermination(10, TimeUnit.SECONDS); // blocking till 10 seconds
    executorService.shutdown();

    System.out.println("Exiting from main, bbye!!!");
  }

  private static BigInteger calculate(int num) {

    System.out.println(
        "In calculate fn for num "
            + num
            + ", thread "
            + Thread.currentThread().getName()
            + ", is daemon ? "
            + Thread.currentThread().isDaemon());

    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= num; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }

    return result;
  }
}
