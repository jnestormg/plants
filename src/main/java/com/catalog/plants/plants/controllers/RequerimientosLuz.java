package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.catalog.plants.plants.repositories.requerimientosLuzRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RequerimientosLuz {

    @Autowired
    private requerimientosLuzRepository repository;

    @GetMapping("/requerimiento-luz")    
    public List<com.catalog.plants.plants.entities.RequerimientosLuz> mostraRequerimientosLuz(){
        return repository.findAll();
    }
    
}
