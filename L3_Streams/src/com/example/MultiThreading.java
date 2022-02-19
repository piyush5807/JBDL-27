package com.example;

public class MultiThreading {

  public static void main(String[] args) throws InterruptedException {
      MyThread thread = new MyThread();
      thread.setPriority(10);
      thread.run(); // thread.run == thread.start

      Thread.sleep(3000);

      System.out.println("In thread: " + Thread.currentThread());

//      System.out.println(Runtime.getRuntime().totalMemory());
//      System.out.println(Runtime.getRuntime().freeMemory());

  }

  // 1. Always main function sysout
  // 2. Always run function sysout
  // 3. Unpredictable

  // Name Priority Group name

  private static class MyThread extends Thread{

      @Override
      public void run(){
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          System.out.println("In thread: " + currentThread());
      }
  }
}
