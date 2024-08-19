package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Suelo;
import com.catalog.plants.plants.repositories.sueloRepository;

@RestController
public class sueloController {

    @Autowired
    private sueloRepository repository;

    @GetMapping("/suelo")
    public List<Suelo> mostarSuelos(){
        return repository.findAll();
    }
    
}
