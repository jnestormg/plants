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

        boolean familiaIsExists=repository.existsById(1l);

        try {
            
            if (familiaIsExists) {
                return null;
            }
            else{
                familias asteracea= new familias(1l,"Asteracea", "margaritas, girasoles y critantemos");
                familias Rosaceae= new familias(2l,"Rosaceae", "rosas, manzanas, peras y fresas");
                familias Solanaceae= new familias(3l,"Solanaceae", "tomates, patatas, berenjenas y pimientos");
                familias Liliaceae= new familias(4l,"Liliaceae", "lirios, tulipanes y azucenas");
                familias Orchidaceae= new familias(5l,"Orchidacea", "orquideas");
                familias Fabaceae= new familias(6l,"Fabaceae", "frijoles, guisantes y treboles");
                familias Poaceae= new familias(7l,"Poaceae", "trigo, maíz y arroz");
                familias Cactaceae= new familias(8l,"Cactaceae", "cactus");
                familias Rutaceae= new familias(9l,"Rutaceae", "limones, naranjas y pomelos");
                familias Brassicaceae= new familias(10l,"Brassicaceae", "coles, rabanos y mostazas");
        
                lFamilias= Arrays.asList(asteracea, Rosaceae, Solanaceae, Liliaceae,
                Orchidaceae, Fabaceae, Poaceae, Cactaceae, Rutaceae, Brassicaceae);
        
                return repository.saveAll(lFamilias);
            }

        } catch (Exception e) {
        }

       return null;
    }

    @GetMapping("/familias")
    public List<familias> mostrarFamilias(){
        return repository.findAll();
    }
}
