package com.hiring.devs.service;


import com.hiring.devs.dto.LoginRequest;
import com.hiring.devs.entity.Developer;
import org.springframework.stereotype.Service;


public interface DeveloperService {

    public Developer register(Developer developer);

    public String login(LoginRequest loginRequest);

}
