package com.catalog.plants.plants.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Flores;
import com.catalog.plants.plants.repositories.floresRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@RestController
public class FloresController {
    

    @Autowired
    private floresRepository repository;

    private static List<Flores> cFlores;

  
    @PostConstruct
    public void init(){
        agregarColores();
    }

    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/flores")
    public void agregarColores(){
     

        try {
            boolean flor=repository.existsById(1l);
    
            if (flor) {
              
            }
            else{

                Flores blanca= new Flores(1l,"Blanco");
                Flores roja= new Flores(2l,"Rojo");
                Flores rosa= new Flores(3l,"Rosa");
                Flores amarilla = new Flores(4l,"Amarillo");
                Flores naranja= new Flores(4l,"Naranja");
                Flores morado= new Flores(5l,"Morado");
                Flores violeta= new Flores(6l,"Violeta");
                Flores verde = new Flores(7l,"Verde");
                Flores negro= new Flores(8l,"Negro");
                Flores multicolor= new Flores(9l,"Multicolor");

                cFlores =Arrays.asList(blanca,roja, rosa, amarilla,
                naranja, morado, violeta, verde, negro, multicolor );

                repository.saveAll(cFlores);

            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }


    @GetMapping("/flores")
    public ResponseEntity<List<Flores>> mostrarFlores(){
        List<Flores> flores= repository.findAll();

        return ResponseEntity.ok(flores);
    }

}
