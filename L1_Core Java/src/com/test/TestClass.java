package com.test;

import com.example.Person;

public class TestClass extends Person{

    public void test(){
        this.country = "India";
    }

    public static void main(String[] args) {
        Person person = new Person();
    }
}
