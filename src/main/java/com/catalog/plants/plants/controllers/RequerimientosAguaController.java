package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.RequerimientosAgua;
import com.catalog.plants.plants.repositories.requerimientosAguaRepository;;

@RestController
public class RequerimientosAguaController {

    @Autowired
    private requerimientosAguaRepository repository;

    @GetMapping("/requerimientos-agua")
    public List<RequerimientosAgua> mostrarRequerimientosAgua(){
        return repository.findAll();
    }
}
