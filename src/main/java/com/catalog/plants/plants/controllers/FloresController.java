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
        Flores blanca= new Flores("Blanco");
        Flores roja= new Flores("Rojo");
        Flores rosa= new Flores("Rosa");
        Flores amarilla = new Flores("Amarillo");
        Flores naranja= new Flores("Naranja");
        Flores morado= new Flores("Morado");
        Flores violeta= new Flores("Violeta");
        Flores verde = new Flores("Verde");
        Flores negro= new Flores("Negro");
        Flores multicolor= new Flores("Multicolor");
    
        cFlores =Arrays.asList(blanca,roja, rosa, amarilla,
         naranja, morado, violeta, verde, negro, multicolor );
         
        return repository.saveAll(cFlores);
    }


    @GetMapping("/flores")
    public List<Flores> mostrarFlores(){
        return repository.findAll();
    }

}
