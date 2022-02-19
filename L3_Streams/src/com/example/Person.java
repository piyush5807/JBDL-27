package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Person {

    private int age;
    private String firstName;
    private String lastName;

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person(10, "Jim", "Parker"), // 100
                new Person(50, "Dwayne", "Johnson"), // 2500
                new Person(20, "John", "Hopkins"), // 400
                new Person(30, "Sussane", "Williams"), // 900
                new Person(40, "Brandon", "Williams"), // 1600
                new Person(5, "Peter", "Roberts"), // 26
                new Person(15, "Tim", "Simothy") // 226
        );

        // Q1. To find all the people who have firstname of 3 characters long
//        people.stream()
//                .filter(x -> x.getFirstName().length() == 3)
//                .forEach((y) -> System.out.println(y));

        // Q2. To find the first person in the collection whose age is >= 20

        // 1. John
        // 2. Sussane
        // 3. Unpredictable


//        Person person2 = people.stream().filter(x -> x.getAge() >= 40)
//                .findFirst().get(); // Depends on two things : Which type of collection, Which type of stream
//
//        Person person3 = people.stream().filter(x -> x.getAge() >= 40)
//                .findFirst().orElseThrow(() -> new MyOwnException("Element is not found")); // Depends on two things : Which type of collection, Which type of stream
//
//        System.out.println("person3" + person3);


//        System.out.println(getFirstPersonGTAge(people, 20));

        System.out.println(people.stream()
                .filter(x -> {
                    System.out.println("Inside filter function, for element : " + x.getFirstName());
                    return x.getAge() >= 20;
                }).map( x -> {
                    System.out.println("Inside map function, for element : " + x.getFirstName());
                    return x.getAge() + 100;
                })
                .findFirst().orElse(null)); // Depends on two things : Which type of collection, Which type of stream

//        System.out.println("person1 = " + person1);

        // Q3. You need to print square of all the even ages of people and square + 1 of all the odd ages

        // 1. All set logs first then all foreach logs
        // 2. First set age then foreach and so on... (pattern)
        // 3. No pattern

        people.stream().map(x -> {
            System.out.println("Setting age for x: " + x.firstName);

            if(x.getAge() % 2 == 0){
                x.setAge(x.getAge() * x.getAge());
            }else{
                x.setAge(x.getAge() * x.getAge() + 1);
            }
            return x;
        }).collect(Collectors.toList()) // Stream 1 -> List
                .stream()
                .forEach(y -> {
            System.out.println("In foreach for person: " + y.getFirstName());
        });

    }

    public static Person getFirstPersonGTAge(List<Person> people, int age){
        for(int i = 0; i < people.size(); i++){
            System.out.println("Checking for person: " + people.get(i).firstName);
            if(people.get(i).getAge() >= age){
                return people.get(i);
            }
        }

        return null;
    }
}
