package com.hiring.devs.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DeveloperDto {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
