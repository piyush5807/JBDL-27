package com.example.jbdl.apis;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Component
public class Employee {

    private Integer id;
//    private String employeeId;

    @NotNull
    private String name;

    @Min(18)
    @Max(60)
    private int age;

    private Gender gender;

    @Email
    private String email;

    // if the request attribute is not found in the reflection search
    // done by the convertor, it will be ignored

//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(String employeeId) {
//        this.employeeId = employeeId;
//    }

//    public static void main(String[] args) {
//        Employee employee = new Employee();
//        employee.setName("ABC");
//
//        System.out.println(employee.age + " " + employee.id + " "
//                + employee.name + " " + employee.gender);
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
