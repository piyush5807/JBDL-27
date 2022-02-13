package com.example;

@FunctionalInterface
public interface DemoInterface<I, S> {

    void accept(I i, S s);

    String toString();
}
