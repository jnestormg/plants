package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Suelo;
import com.catalog.plants.plants.repositories.sueloRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class sueloController {

    @Autowired
    private sueloRepository repository;

    private static List<Suelo> tSuelos;

    @PostConstruct
    public void init(){
        agregarSuelos();
    }

    @PostMapping("/suelo")
    public List<Suelo> agregarSuelos(){
        Suelo arenoso= new Suelo("Arenoso");
        Suelo arcilloso= new Suelo("Arenoso");
        Suelo limoso= new Suelo("Limoso");
        Suelo franco= new Suelo("Franco");
        Suelo calcareo = new Suelo("Calcáreo");
        Suelo turboso= new Suelo("Turboso");

        tSuelos= Arrays.asList(arenoso, arcilloso, limoso, franco, calcareo, turboso);

        return repository.saveAll(tSuelos);
    }

    @GetMapping("/suelo")
    public List<Suelo> mostarSuelos(){
        return repository.findAll();
    }
    
}
