package com.catalog.plants.plants.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.Plantas;
import com.catalog.plants.plants.repositories.plantasReposority;

@RestController
@RequestMapping("/api/v1")
public class plantasController {

    @Autowired
    private plantasReposority repository;

    @GetMapping("/plantas")
    public List<Plantas> mostrarPlantas() {
        return repository.findAll();
    }

    @PostMapping("/plantas")
    public Plantas guardarPlanta(@RequestBody Plantas planta) {
        return repository.save(planta);
    }


    @GetMapping("/plantas/{id}")
    public Plantas buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/plantas/{id}")
    public Plantas actualizarPlantas(@RequestBody Plantas planta, @PathVariable Long id) {
        Plantas plant = repository.findById(id).orElseThrow();
        plant.setNombre(planta.getNombre());
        plant.setDescripcion(planta.getDescripcion());
        plant.setFoto(planta.getFoto());
        return repository.save(plant);
    }


    @DeleteMapping("/plantas/{id}")
    public void borrarPlanta(@PathVariable Long id) {
        Plantas plant = repository.findById(id).orElseThrow();
        repository.delete(plant);
        
    }



}
