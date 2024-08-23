package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.RequerimientosAgua;
import com.catalog.plants.plants.repositories.requerimientosAguaRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;;

@RestController
public class RequerimientosAguaController {

    @Autowired
    private requerimientosAguaRepository repository;

    private static List<RequerimientosAgua> tRequerimientosAgua;

    @PostConstruct
    public void init(){
        agregarRequerimientosAguas();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/requerimientos-agua")
    public void agregarRequerimientosAguas(){


        try {
            boolean requerimentoIsExists= repository.existsById(1l);

            if (requerimentoIsExists) {
            }
            else{
                RequerimientosAgua bajo= new RequerimientosAgua(1l,"Bajo");
                RequerimientosAgua medio = new RequerimientosAgua(2l,"Medio");
                RequerimientosAgua alto =  new RequerimientosAgua(3l,"Alto");
        
                tRequerimientosAgua=Arrays.asList(bajo, medio, alto);
        
                repository.saveAll(tRequerimientosAgua);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

    }

    @GetMapping("/requerimientos-agua")
    public ResponseEntity<List<RequerimientosAgua>> mostrarRequerimientosAgua(){
        List<RequerimientosAgua> requerimientosAgua= repository.findAll();

        return ResponseEntity.ok(requerimientosAgua);
    }
}
