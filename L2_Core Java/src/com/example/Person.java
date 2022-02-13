package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Person {

    private String firstName;
    private int age;
    private String lastName;

    public Person(String firstName, int age, String lastName) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age); // h1
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.age = 10;
        person.firstName = "Jim";
        person.lastName = "Feng";

        Person person2 = new Person();
        person2.age = 10;
        person2.firstName = "Jim";
        person2.lastName = "Feng";

        System.out.println(person.hashCode() + " " + person2.hashCode());
        System.out.println(person.equals(person2));


//        HashMap<Person, Boolean> hashMap = new HashMap<>();
//        hashMap.put(person, false);
//        hashMap.put(person2, true);
//
//        System.out.println(hashMap.get(person));

        HashSet<Person> peopleSet = new HashSet<>();
        peopleSet.add(person);
        peopleSet.add(person2);

        System.out.println(peopleSet);




//        System.out.println(hashMap);

    }
}
