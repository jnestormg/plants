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
        
        boolean sueloIsExists= repository.existsById(1l);

        try {
            if (sueloIsExists) {
                return null;
            }
            else{
                Suelo arenoso= new Suelo(1l,"Arenoso");
                Suelo arcilloso= new Suelo(2l,"Arenoso");
                Suelo limoso= new Suelo(3l,"Limoso");
                Suelo franco= new Suelo(4l,"Franco");
                Suelo calcareo = new Suelo(5l,"Calcáreo");
                Suelo turboso= new Suelo(6l,"Turboso");
        
                tSuelos= Arrays.asList(arenoso, arcilloso, limoso, franco, calcareo, turboso);
        
                return repository.saveAll(tSuelos);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
     
    }

    @GetMapping("/suelo")
    public List<Suelo> mostarSuelos(){
        return repository.findAll();
    }
    
}
