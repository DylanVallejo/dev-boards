package com.hiring.devs.service.impl;

import com.hiring.devs.dto.LoginRequest;
import com.hiring.devs.entity.Developer;
import com.hiring.devs.repository.DeveloperRepository;
import com.hiring.devs.service.DeveloperService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public Developer register(Developer developer) {
        Developer developerNew = new Developer();

        BeanUtils.copyProperties(developer, developerNew);
        developerRepository.save(developerNew);
        return developerNew;

    }

    @Override
    public String login(LoginRequest loginRequest) {
        return "";
    }
}
