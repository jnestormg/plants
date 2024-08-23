package com.catalog.plants.plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.catalog.plants.plants.entities.Habitats;
import com.catalog.plants.plants.entities.Plantas;
import com.catalog.plants.plants.repositories.habitatsRepository;
import com.catalog.plants.plants.repositories.plantasReposority;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class plantasController {

    @Autowired
    private plantasReposority repository;

    @Autowired
    private habitatsRepository habitatsRepository;

    @GetMapping("/plantas")
    public ResponseEntity<List<Plantas>> mostrarPlantas() {
        // return repository.findAll(Sort.by(Sort.Direction.DESC));
        List<Plantas> plantas= repository.findAll();

        return ResponseEntity.ok(plantas);
    }

    @PostMapping("/plantas")
    public ResponseEntity<Plantas> guardarPlanta(@RequestBody Plantas planta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(planta));
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
        plant.setAltura(planta.getAltura());
        plant.setToxicidad(planta.getToxicidad());
        return repository.save(plant);
    }

    @DeleteMapping("/plantas/{id}")
    public void borrarPlanta(@PathVariable Long id) {
        Plantas plant = repository.findById(id).orElseThrow();
        repository.delete(plant);

    }

    @GetMapping("/plantas/nombre/{nombre}")
    public List<Plantas> buscarPorNombre(@PathVariable String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    @GetMapping("/planta")
    public Object buscarPorNpmbre(@RequestParam String nombre) {
        List<Plantas> listaPlantas = repository.findByNombre(nombre);
        return listaPlantas;
    }

    @GetMapping("/planta/name/{nombre}")
    List<Plantas> buscarPorNombreLike(@PathVariable String nombre) {
        return repository.buscarPorNombreLikeAdvance(nombre);
    }

}
