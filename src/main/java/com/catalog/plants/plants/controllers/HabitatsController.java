package com.catalog.plants.plants.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public void init() {
        agregarHabitats();
    }

    @PostMapping("/habitats")
    public List<Habitats> agregarHabitats() {

        boolean habitat = repository.existsById(1l);

        try {
            if (habitat) {
                return null;
            } else {
                Habitats tropical = new Habitats(1l,"Tropical");
                Habitats desierto = new Habitats(2l,"Desierto");
                Habitats pradera = new Habitats(3l,"Pradera");
                Habitats humedal = new Habitats(4l,"Humedal");
                Habitats montana = new Habitats(5l,"Montaña");
                Habitats sabana = new Habitats(6l,"Sabana");
                Habitats manglar = new Habitats(7l,"Manglar");
                Habitats oceano = new Habitats(8l,"Océano");
                Habitats Mar = new Habitats(9l,"Mar");
                Habitats rio = new Habitats(10l,"Río");
                Habitats lago = new Habitats(11l, "Lago");

                tHabitats = Arrays.asList(tropical, desierto, pradera, humedal, montana,
                        sabana, manglar, oceano, Mar, rio, lago);

                return repository.saveAll(tHabitats);
            }
        } catch (Exception e) {
        }
        return null;

    }

    @GetMapping("/habitats")
    public List<Habitats> mostrarHabitats() {
        return repository.findAll();
    }
}
