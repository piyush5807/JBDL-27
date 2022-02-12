package com.example;

public abstract class PersonAbstractClass {
    // In an abstract class you can have non-abstract functions also
    // In a non-abstract class you cannot have abstract methods

    protected abstract void testSomething();

    public String test(){
        return "Hello";
    }
}
