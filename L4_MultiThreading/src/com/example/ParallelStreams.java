package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ParallelStreams {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // q1. You are given a list of numbers, you need to calculate the sum of squares of even numbers
      // q2. You are given a list of numbers, you need to the first even number
      // q3. You are given a list of numbers, you have to print the square of each number

      List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      // Forkjoinpool.CommonPool -> Workers = Runtime.getRuntime().getAvailableProcessors() - 1;
      // +1 main thread

      System.out.println(al.stream().parallel()
              .filter(x -> x % 2 == 0)
              .findAny().orElse(null)); // Returning any even number because of the type of stream + terminal operation

      // 1. Type of Collection
      // 2. Type of stream
      // 3. Type of terminal operation

//      System.out.println(al.stream().parallel().filter(x -> {
//          System.out.println("In filter for x: " + x + ", thread: " + Thread.currentThread().getName());
//          return x % 2 == 0;
//      }).findFirst().orElse(null));
//
//
//      al.stream().map(x -> x * x).forEach(System.out::println);
//

//      executorService.submit(() -> al.stream()
//              .filter(x -> {
//                  System.out.println("In filter for x: " + x + ", thread: " + Thread.currentThread().getName());
//                  return x % 2 == 0;
//              })
//              .map(x -> {
//                  System.out.println("In map for x: " + x + ", thread: " + Thread.currentThread().getName());
//                  return x * x;
//              })
//              .forEach(x -> {
//                  System.out.println("In for each for x: " + x + ", thread: " + Thread.currentThread().getName());
//              }));

//      al.stream()
//              .parallel()
//              .filter(x -> {
//                  System.out.println("In filter for x: " + x + ", thread: " + Thread.currentThread().getName());
//                  return x % 2 == 0;
//              })
//              .map(x -> {
//                  System.out.println("In map for x: " + x + ", thread: " + Thread.currentThread().getName());
//                  return x * x;
//              })
//              .forEach(x -> {
//                  System.out.println("In for each for x: " + x + ", thread: " + Thread.currentThread().getName());
//              });

//      ForkJoinPool forkJoinPool = new ForkJoinPool(10);
//
//      Future<Integer> future = forkJoinPool.submit(() -> al.parallelStream()
//              .filter(x -> {
//                  System.out.println("In filter for x: " + x + ", thread: " + Thread.currentThread().getName() + ", isDaemon " + Thread.currentThread().isDaemon());
//                  return x % 2 == 0;
//              })
//              .map(x -> {
//                  System.out.println("In map for x: " + x + ", thread: " + Thread.currentThread().getName());
//                  return x * x;
//              })
//              .reduce(0, (x, y) -> {
//                  System.out.println("In reduce for x, y: " + x + ", " + y + ", thread: " + Thread.currentThread().getName());
//                  return x + y;
//              }));
//
//      System.out.println(future.get());

      //

  }
}
