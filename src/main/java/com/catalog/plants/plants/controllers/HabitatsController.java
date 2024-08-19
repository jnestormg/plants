package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Habitats;
import com.catalog.plants.plants.repositories.habitatsRepository;

@RestController
public class HabitatsController {
    
    @Autowired
    private habitatsRepository repository; 

    @GetMapping("/habitats")
    public List<Habitats> mostrarHabitats(){
        return repository.findAll();
    }
}
