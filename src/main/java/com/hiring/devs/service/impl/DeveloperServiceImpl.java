package com.hiring.devs.service.impl;

import com.hiring.devs.dto.LoginRequest;
import com.hiring.devs.entity.Developer;
import com.hiring.devs.mappers.DeveloperMapper;
import com.hiring.devs.repository.DeveloperRepository;
import com.hiring.devs.service.DeveloperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    private PasswordEncoder passwordEncoder;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    DeveloperMapper developerMapper;

    @Override
    public Developer register(Developer developer) {
        Developer developerNew = new Developer();
        developerNew.setFirst_name(developer.getFirst_name());
        developerNew.setLast_name(developer.getLast_name());
        developerNew.setEmail(developer.getEmail());
        developerNew.setState(developer.getState());
        developerNew.setCity(developer.getCity());
        developerNew.setAddress(developer.getAddress());
        developerNew.setTechnology(developer.getTechnology());

        return developerRepository.save(developerNew);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return "";
    }
    public void setTechnologys(Developer developer){
        developer.setTechnology(developer.getTechnology());
    }

}
