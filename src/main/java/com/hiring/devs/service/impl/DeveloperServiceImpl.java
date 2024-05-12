package com.hiring.devs.service.impl;

import com.hiring.devs.dto.LoginRequest;
import com.hiring.devs.entity.Developer;
import com.hiring.devs.entity.DeveloperTechnology;
import com.hiring.devs.entity.Technology;
import com.hiring.devs.repository.DeveloperRepository;
import com.hiring.devs.repository.DeveloperTechnologyRepository;
import com.hiring.devs.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mbeans.MBeanUtils;
import org.checkerframework.checker.units.qual.A;
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

    @Autowired
    DeveloperTechnologyRepository devTechnologyRepository;

    private PasswordEncoder passwordEncoder;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Developer register(Developer developer) {
        Developer developerNew = new Developer();
        BeanUtils.copyProperties(developer, developerNew);
        developerNew.setPassword(passwordEncoder.encode(developer.getPassword()));
        setTechnologys(developer);
        developerRepository.save(developerNew);
        return developerNew;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return "";
    }

    public void setTechnologys(Developer developer){

        if (developer.getTechnology() != null) {
            developer.getTechnology().forEach(technology -> {
                DeveloperTechnology developerTechnology = new DeveloperTechnology();
                developerTechnology.setDeveloper_id(developer.getId());
                developerTechnology.setTechnology_id(technology.getId()); // Accede al ID de la tecnología
                devTechnologyRepository.save(developerTechnology);
            });
        }

    }
}
