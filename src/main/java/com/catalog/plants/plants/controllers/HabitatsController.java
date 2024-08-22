package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catalog.plants.plants.entities.Habitats;
import com.catalog.plants.plants.repositories.habitatsRepository;
import jakarta.annotation.PostConstruct;

@RestController
public class HabitatsController {
    
    @Autowired
    private habitatsRepository repository; 

    private static List<Habitats> tHabitats;

    @PostConstruct
    public void init(){
        agregarHabitats();
    }

    @PostMapping("/habitats")
    public List<Habitats> agregarHabitats(){

        Habitats tropical= new Habitats("Tropical");
        Habitats desierto= new Habitats("Desierto");
        Habitats pradera= new Habitats("Pradera");
        Habitats humedal= new Habitats("Humedal");
        Habitats montana= new Habitats("Montaña");
        Habitats sabana= new Habitats("Sabana");
        Habitats manglar= new Habitats("Manglar");
        Habitats oceano= new Habitats("Océano");
        Habitats Mar= new Habitats("Mar");
        Habitats rio= new Habitats("Río");
        Habitats lago= new Habitats("Lago");

        tHabitats=Arrays.asList(tropical, desierto, pradera, humedal, montana,
        sabana, manglar, oceano, Mar, rio, lago);

        return repository.saveAll(tHabitats);
    }

    @GetMapping("/habitats")
    public List<Habitats> mostrarHabitats(){
        return repository.findAll();
    }
}
