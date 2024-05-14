package com.hiring.devs.controller;


import com.hiring.devs.entity.Technology;
import com.hiring.devs.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<List<Technology>> listarTecnologias(){

        try {
            List<Technology> listaTecnologias = technologyService.listTechnologys();
            return new ResponseEntity<>(listaTecnologias,HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{technologyId}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Long technologyId){
        try {
            technologyService.eliminarTecnologia(technologyId);
            return new ResponseEntity<>("Tecnologia con el id: " + technologyId+ " eliminada", HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
