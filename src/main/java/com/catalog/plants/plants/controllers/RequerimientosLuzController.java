package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.RequerimientosLuz;
import com.catalog.plants.plants.repositories.requerimientosLuzRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RequerimientosLuzController {

    @Autowired
    private requerimientosLuzRepository repository;

    private static List<RequerimientosLuz> tRequerimientosLuz;

    @PostConstruct
    public void init(){
        agregaRequerimientosLuz();
    }

    @PostMapping("/requerimiento-luz")
    public List<RequerimientosLuz> agregaRequerimientosLuz(){
        RequerimientosLuz sol = new RequerimientosLuz("Sol total");
        RequerimientosLuz sombra= new RequerimientosLuz("Sombra parcial");
        
        tRequerimientosLuz= Arrays.asList(sol, sombra);

        return repository.saveAll(tRequerimientosLuz);
    }

    @GetMapping("/requerimiento-luz")    
    public List<com.catalog.plants.plants.entities.RequerimientosLuz> mostraRequerimientosLuz(){
        return repository.findAll();
    }
    
}
