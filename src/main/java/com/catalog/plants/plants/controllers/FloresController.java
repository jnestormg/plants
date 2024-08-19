package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Flores;
import com.catalog.plants.plants.repositories.floresRepository;

@RestController
public class FloresController {
    

    @Autowired
    private floresRepository repository;

    @GetMapping("/flores")
    public List<Flores> mostrarFlores(){
        return repository.findAll();
    }

}
