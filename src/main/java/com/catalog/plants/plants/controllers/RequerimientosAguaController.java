package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.RequerimientosAgua;
import com.catalog.plants.plants.repositories.requerimientosAguaRepository;

import jakarta.annotation.PostConstruct;;

@RestController
public class RequerimientosAguaController {

    @Autowired
    private requerimientosAguaRepository repository;

    private static List<RequerimientosAgua> tRequerimientosAgua;

    @PostConstruct
    public void init(){
        agregarRequerimientosAguas();
    }

    @PostMapping("/requerimientos-agua")
    public List<RequerimientosAgua> agregarRequerimientosAguas(){

        RequerimientosAgua bajo= new RequerimientosAgua("Bajo");
        RequerimientosAgua medio = new RequerimientosAgua("Medio");
        RequerimientosAgua alto =  new RequerimientosAgua("Alto");

        tRequerimientosAgua=Arrays.asList(bajo, medio, alto);

        return repository.saveAll(tRequerimientosAgua);
    }

    @GetMapping("/requerimientos-agua")
    public List<RequerimientosAgua> mostrarRequerimientosAgua(){
        return repository.findAll();
    }
}
