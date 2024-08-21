package com.catalog.plants.plants.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Flores;
import com.catalog.plants.plants.repositories.floresRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class FloresController {
    

    @Autowired
    private floresRepository repository;

    private static List<Flores> cFlores;

  
    @PostConstruct
    public void init(){
        agregarColores();
    }

   
    @PostMapping("/flores")
    public List<Flores> agregarColores(){
        Flores blanca= new Flores("Blanca");
        Flores roja= new Flores("Roja");
        Flores amarilla = new Flores("Amarilla");
        Flores verde = new Flores("Verde");
        cFlores =Arrays.asList(blanca,verde,roja, amarilla);
        return repository.saveAll(cFlores);
    }


    @GetMapping("/flores")
    public List<Flores> mostrarFlores(){
        return repository.findAll();
    }

}
