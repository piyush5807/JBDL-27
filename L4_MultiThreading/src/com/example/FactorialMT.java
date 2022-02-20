package com.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorialMT {

    // Application will run as long as there is even a single non daemon thread running
    // dameon - background

    public static void main(String[] args) {
//        Thread.currentThread().setDaemon(true);  // This is not possible
        List<Integer> al = Arrays.asList(10000, 20000, 30000, 50000, 23000, 56000, 45000, 50000, 70000, 48000, 54000);

        MyThread[] threads = new MyThread[al.size()];

        long start = System.currentTimeMillis();

        FactorialMT o = new FactorialMT();

        IntStream.range(0, al.size()).forEach(i -> {
            threads[i] = o.new MyThread(al.get(i));
            threads[i].start(); //

        });

        Arrays.stream(threads).forEach(x -> {
            try {
                x.join(); // This is a blocking call, your program will move ahead unless the given thread completes
                System.out.println(x.result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();

        System.out.println("Time taken : " + (end - start));
    }

    private class MyThread extends Thread{

        private int num;
        private BigInteger result;

        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            // Calculating the factorial
            try {
                Thread.sleep(2000);
                currentThread().setDaemon(true);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            calculate(this.num);
        }

        private BigInteger calculate(int num){
            System.out.println("In calculate fn for num " + num +
                    ", thread " + Thread.currentThread().getName() + ", is daemon ? " + Thread.currentThread().isDaemon());

            for(int i = 2; i <= num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }

            return this.result;
        }
    }
}
