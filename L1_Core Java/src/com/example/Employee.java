package com.example;

import com.test.TestClass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee extends Person {

    // Overriding is having same function in both child and parent class
//    @Override
    public int getAge(){
        System.out.println("In Employee: getAge function");
        return 100;
    }

    public String testFunc(){
        return "random text";
    }

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>(); // Access any member function of arraylist class
        List<String> al2 = new ArrayList<>(); // access those functions which are defined in list interface and
        // overriden by implementing class

        Map<String, Object> map = new HashMap<>();


//        Class<Person> clss = Person.class;
//        Method[] methods = clss.getDeclaredMethods();
//
//        for(Method method : methods){
//            if(method.getName() == "getBMI" && method.getParameterCount() == 1) {
//                System.out.println(method.getName() + " " + method.getParameterCount());
//            }
//        }


        /**
         * Person o = new Person()
         * Person o = new Employee()
         * Employee o = new Employee();
         * Employee o = new Person();

         **/

        /**
         * Reference - before = the object which is mentioned
         * Object - after =
         **/

        // 10               // 12 - 10 = 2
//        Person employee = new Employee();
//        // We are restricting the usage of functions which are not declared in parent class
//
//        System.out.println(employee.testFunc());


        Person p = new Person();
        System.out.println(p.getWeight() + " " + p.getHeight());
        System.out.println(PersonOps.getHeight());

//        PersonOps o = new Person();
//        System.out.println(o.getBMI());

//        Employee o = new Person(); // Not possible
    }
}
