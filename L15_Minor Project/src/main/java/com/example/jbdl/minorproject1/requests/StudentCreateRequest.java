package com.example.jbdl.minorproject1.requests;

import com.example.jbdl.minorproject1.models.Student;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    @Positive
    private int age;

    @NotBlank
    private String name;

    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    public Student to(){
        return Student.builder()
                .name(name)
                .age(age)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
