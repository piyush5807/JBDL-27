package com.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo implements DemoInterface<String, Integer>{

    public static void getText(String s, int num){

        String ans = "";
        for(int i = 0; i < num; i++){
            ans += s;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {

//        System.out.println(FunctionalInterfaceDemo.getText("Hi!!"));

        // Anonymous inner class
//        DemoInterface demoInterface = new DemoInterface() {
//            @Override
//            public String calculate() {
//                return "Calculating...";
//            }
//        };

//        DemoInterface demoInterface1 = (a, b) -> {
//            System.out.println("In lambda expression....");
//            return String.valueOf(a + b);
//        };

//        System.out.println(demoInterface.calculate());
//        System.out.println(demoInterface1.calculate(2, 3));
//        System.out.println(demoInterface1.calculate2());


//        DemoInterface<String, Integer> consumer = FunctionalInterfaceDemo::getText;
//
//
////      Consumer<String> consumer = (e) -> System.out.println(e);
//        consumer.accept( "Piyush", 2);


//        Supplier<String> supplier = UUID.randomUUID()::toString;
//
//        System.out.println(supplier.get());

        Function<String, Integer> function = Integer::parseInt;


        int a = function.apply("80");
        System.out.println(a);
    }

    @Override
    public void accept(String s, Integer integer) {

    }

    @Override
    public boolean equals(Object o){
        return true;
    }
}
