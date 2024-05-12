package com.hiring.devs.controller;


import com.hiring.devs.dto.LoginRequest;
import com.hiring.devs.entity.Developer;
import com.hiring.devs.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(developerService.login(loginRequest));
    }

    @PostMapping(value = "register")
    public ResponseEntity<Developer> registerDev(@RequestBody Developer developer){
        Developer newDeveloper =  developerService.register(developer);
        return ResponseEntity.ok(newDeveloper);
    }


}
