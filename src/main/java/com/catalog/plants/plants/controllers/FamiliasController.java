package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.plants.plants.entities.familias;
import com.catalog.plants.plants.repositories.familiaRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class FamiliasController {

    @Autowired
    private familiaRepository repository;

    private static List<familias> lFamilias;

    @PostConstruct
    public void init(){
        agregarFamilias();
    }

    @PostMapping("/familias")
    public List<familias> agregarFamilias(){
        familias asteracea= new familias("Asteracea", "margaritas, girasoles y critantemos");
        familias Rosaceae= new familias("Rosaceae", "rosas, manzanas, peras y fresas");
        familias Solanaceae= new familias("Solanaceae", "tomates, patatas, berenjenas y pimientos");
        familias Liliaceae= new familias("Liliaceae", "lirios, tulipanes y azucenas");
        familias Orchidaceae= new familias("Orchidacea", "orquideas");
        familias Fabaceae= new familias("Fabaceae", "frijoles, guisantes y treboles");
        familias Poaceae= new familias("Poaceae", "trigo, maíz y arroz");
        familias Cactaceae= new familias("Cactaceae", "cactus");
        familias Rutaceae= new familias("Rutaceae", "limones, naranjas y pomelos");
        familias Brassicaceae= new familias("Brassicaceae", "coles, rabanos y mostazas");

        lFamilias= Arrays.asList(asteracea, Rosaceae, Solanaceae, Liliaceae,
        Orchidaceae, Fabaceae, Poaceae, Cactaceae, Rutaceae, Brassicaceae);
        
        return repository.saveAll(lFamilias);
    }

    @GetMapping("/familias")
    public List<familias> mostrarFamilias(){
        return repository.findAll();
    }
}
