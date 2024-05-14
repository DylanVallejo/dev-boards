package com.hiring.devs.service;

import com.hiring.devs.entity.Technology;

import java.util.List;

public interface TechnologyService {

     Technology crearTecnologia(Technology technology);

     List<Technology> listTechnologys();

     void eliminarTecnologia(Long tecnologiaId);


}
