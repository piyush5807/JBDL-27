package com.example;

public class Person implements PersonOps, Runnable{

    private static String count = "0";

    /**
     *Private - visible inside the current class
     *Default - visible inside the same package
     *Protected - visible in all the classes of same package + child class of different packages
     *Public - visible everywhere in the project
    **/

    private int age; // 0
    String name; // null
    protected String country; // null
    public String aadharId;
    Integer num; // null

    private double height;
    private double weight;
    private String gender;

    // Constructor overloading
    public Person(int age, String name, String country, String aadharId) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.aadharId = aadharId;
    }

    public Person() {
    }

    // Similar function : same name + same number and type of arguments
    // In java we cannot have two similar functions in a class

    public double getBMI(){
        return 24.0;
    }

    // Not an overloaded function because return type does not matter
//    private String getBMI(){
//        return "";
//    }

    public String getBMI(double weight){
        return "";
    }

    public double getBMI(double weight, double height){
        return weight * height;
    }

    public double getBMI(String gender, double weight){
        return 0.0;
    }

    public double getBMI(double weight, String gender){
        return 0.0;
    }

    public int getAge(){
        System.out.println("In Person: getAge function");
        return this.age;
    }

    public void test(){}

    public String testFunc(){
        return "Parent's random text";
    }

//    @Override
    public static Double getHeight() {
        return 1.5;
    }

    @Override
    public Double getWeight() {
        return 50.0;
    }

    @Override
    public void run() {

    }
}
