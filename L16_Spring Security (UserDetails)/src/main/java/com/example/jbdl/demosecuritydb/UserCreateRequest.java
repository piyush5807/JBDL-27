package com.example.jbdl.demosecuritydb;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {

    @NotBlank
    private String username;

    // Raw password
    @NotBlank
    private String password;

    @NotNull
    private Boolean isDeveloper;

}
