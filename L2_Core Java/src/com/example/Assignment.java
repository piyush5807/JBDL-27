package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Assignment {

    public static void main(String[] args) {
        // Q1. You have a list of numbers, you need to replace every number with the square of the original number

        // [1, 2, 3, 4, 5,6 , 7, 8, 9, 10] --> [1, 4, 9, 16, 25, 36, 49., 64, 81, 100]
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5,6 , 7, 8, 9, 10);
//
//        System.out.println(nums);
//        for(int i = 0; i < nums.size(); i++) {
//            nums.set(i, nums.get(i) * nums.get(i));
//        }
//
//        System.out.println(nums);

        // Q2. You need to calculate the sum of the squares of even numbers in list
        // 2*2 + 4*4 + 6*6 + 8*8 + 10*10 = 220

//        int sum = 0;
//        for(int i = 0; i < nums.size(); i++) {
//            if(nums.get(i) % 2 == 0){
//                sum += nums.get(i) * nums.get(i);
//            }
//        }
//        System.out.println(sum);
//
//
//        // Streams or declarative way of writing code
//
//        int ans = nums.stream()
//                .filter((i) -> i % 2 == 0)
//                .map((x) -> x * x)
//                .reduce(1, (i1, i2) -> i1 + i2);
////
//        System.out.println(ans);

        // Given a list of person, you need to find the sum of all the ages of person

        List<Person> people = Arrays.asList(
                new Person("John", 10, "Hopkins"),
                new Person("Anna", 20, "Hathaway"),
                new Person("Suzie", 30, "Bates"),
                new Person("Jim", 40, "Carey"),
                new Person("Anna", 50, "Carey")

                );

        System.out.println(
                people.stream()
                .map(Person::getAge)
                .reduce(0, Math::addExact)
        );

        // 1 terminal

        System.out.println(
                people.stream()
                        .filter(x -> x.getFirstName().equals("Anna"))
                        .findAny()
        );
    }

    // 1. Parallel streams
    // 2. Time complexity comparison b/w stream and a normal iterative approach
    // 3. Terminal and non-terminal functions, trigger point of a stream


    // Identity -> If you carry out an operation on an element with the identity element, the ans is that element only

    // 6 + 0 = 6
    // 6 * 1 = 6
}
