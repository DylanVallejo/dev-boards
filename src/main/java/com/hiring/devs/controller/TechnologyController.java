package com.hiring.devs.controller;


import com.hiring.devs.entity.Technology;
import com.hiring.devs.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @PostMapping("/create")
    public ResponseEntity<Technology> crearTecnologia(@RequestBody Technology technology){

        try {
            Technology technologyNew = technologyService.crearTecnologia(technology);
            return  new ResponseEntity<>(technologyNew, HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
