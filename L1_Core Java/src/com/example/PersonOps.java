package com.example;

public interface PersonOps {

    int count = 0;
    // in interface, by default all methods are abstract methods
    // abstract method is a method which does not have a body / definition

    // From java 8 onwards, we can use default functions as well

    // This is not a default scope
    // Default functions are non-abstract functions i.e, they have a body
    default Double getWeight(){
        return 70.0;
    }

    static Double getHeight(){
        return 1.3;
    }
}
