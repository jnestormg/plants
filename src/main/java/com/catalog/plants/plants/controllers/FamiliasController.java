package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.familias;
import com.catalog.plants.plants.repositories.familiaRepository;

@RestController
public class FamiliasController {

    @Autowired
    private familiaRepository repository;

    @GetMapping("/familias")
    public List<familias> mostrarFamilias(){
        return repository.findAll();
    }
}
