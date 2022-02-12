package com.example;

public final class FinalKeyword extends Person{

    /**
     * Variables - final instance/member variables can be defined either
                1. In a block
                2. Constructor
                3. While declaring
                   final static variable can de defined either
                1. In a static block
                2. While declaring
     * Functions - Functions which cannot be overridden in the child class
     * Classes - Classes which cannot be inherited, by default all the functions
                 in a final class are automatically final
     **/

    public final int count;
    public static final int count2;

    {
        this.count = 100;
    }

    static {
        count2 = 200;
    }

//    FinalKeyword(){
////        this.count = 100;
//    }

    public final void test(){
        System.out.println("Testing in FinalKeyword class");
    }

    public void test2(){
        System.out.println("Testing2 in FinalKeyword class");

        this.aadharId = "Random adharId";
        this.aadharId = "Random adharId";
        this.aadharId = "Random adharId";

    }

    public static void main(String[] args) {
        FinalKeyword o = new FinalKeyword();
//        o.count = 200;
        System.out.println(o.count);


    }
}
