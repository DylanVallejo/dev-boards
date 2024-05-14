package com.hiring.devs.service.impl;

import com.hiring.devs.entity.Technology;
import com.hiring.devs.repository.TechnologyRepository;
import com.hiring.devs.service.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyRepository technologyRepository;

    @Override
    public Technology crearTecnologia(Technology technology) {
        Technology createTechnology = new Technology();
        createTechnology.setName(technology.getName());
        if (technology.getIs_framework() != null){
            createTechnology.setIs_framework(technology.getIs_framework());
        }
        if (technology.getLogo() != null){
            createTechnology.setLogo(technology.getLogo());
        }

        technologyRepository.save(createTechnology);
        return createTechnology;
    }

    @Override
    public List<Technology> listTechnologys() {
        List<Technology> tecnologias = technologyRepository.findAll();
        if (!tecnologias.isEmpty()){
            return tecnologias;
        }
        return List.of(null);
    }

    @Override
    public void eliminarTecnologia(Long tecnologiaId) {
        technologyRepository.deleteById(tecnologiaId);
    }


}
