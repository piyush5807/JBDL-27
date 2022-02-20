package com.example;

public class Main {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadFunction();
            }
        }).start();

        new Thread(Main::threadFunction) // Class::method
                .start();
    }

    public static void threadFunction(){
        System.out.println("In function: threadFunction, thread: " + Thread.currentThread());
    }
}
