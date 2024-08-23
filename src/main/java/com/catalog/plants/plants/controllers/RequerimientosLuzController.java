package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.RequerimientosLuz;
import com.catalog.plants.plants.repositories.requerimientosLuzRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class RequerimientosLuzController {

    @Autowired
    private requerimientosLuzRepository repository;

    private static List<RequerimientosLuz> tRequerimientosLuz;

    @PostConstruct
    public void init() {
        agregaRequerimientosLuz();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/requerimiento-luz")
    public void agregaRequerimientosLuz() {


        try {
            boolean requerimentoIsExists = repository.existsById(1l);

            if (requerimentoIsExists) {
            } else {

                RequerimientosLuz sol = new RequerimientosLuz(1l,"Sol total");
                RequerimientosLuz sombra = new RequerimientosLuz(2l,"Sombra parcial");

                tRequerimientosLuz = Arrays.asList(sol, sombra);

                repository.saveAll(tRequerimientosLuz);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

    }

    @GetMapping("/requerimiento-luz")
    public ResponseEntity<List<com.catalog.plants.plants.entities.RequerimientosLuz>> mostraRequerimientosLuz() {
        List<RequerimientosLuz> requerimientosLuz= repository.findAll();

        return ResponseEntity.ok(requerimientosLuz);

    }

}
