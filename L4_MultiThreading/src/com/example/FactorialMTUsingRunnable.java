package com.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorialMTUsingRunnable {

  public static void main(String[] args) {

      List<Integer> al = Arrays.asList(10000, 20000, 30000, 50000, 23000, 56000, 45000, 50000, 70000, 48000, 54000);

      MyThread[] myThreads = new MyThread[al.size()];
      Thread[] threads = new Thread[al.size()];

      long start = System.currentTimeMillis();

      IntStream.range(0, al.size()).forEach(i -> {
          myThreads[i] = new MyThread(al.get(i)); // Our inner class object
          threads[i] = new Thread(myThreads[i]); // Thread.java's object taking runnable in argument
          threads[i].start();
      });

      IntStream.range(0, al.size()).forEach(i -> {
          try {
              threads[i].join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(myThreads[i].result);
      });

//      Arrays.stream(threads).forEach(x -> {
//          try {
//              x.join(); // This is a blocking call, your program will move ahead unless the given thread completes
//              System.out.println(x.result);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//      });

      long end = System.currentTimeMillis();

      System.out.println("Time taken : " + (end - start));


  }

  private static class MyThread  implements Runnable{

      private int num;
      private BigInteger result;

      public MyThread(int num) {
          this.num = num;
          this.result = BigInteger.ONE;
      }

      @Override
      public void run() {
          // Calculating the factorial
          calculate(this.num);
      }

      private BigInteger calculate(int num){
          System.out.println("In calculate fn for num " + num + ", thread " + Thread.currentThread().getName());

          for(int i = 2; i <= num; i++){
              this.result = this.result.multiply(BigInteger.valueOf(i));
          }

          return this.result;
      }
  }
}
