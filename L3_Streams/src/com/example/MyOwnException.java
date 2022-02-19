package com.example;

public class MyOwnException extends RuntimeException{

    public MyOwnException(String msg) {
        super(msg);
        System.out.println("Some error occurred");
    }
}
