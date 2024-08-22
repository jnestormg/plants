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

        boolean requerimentoIsExists= repository.existsById(1l);

        try {
            if (requerimentoIsExists) {
                return null;
            }
            else{
                RequerimientosAgua bajo= new RequerimientosAgua(1l,"Bajo");
                RequerimientosAgua medio = new RequerimientosAgua(2l,"Medio");
                RequerimientosAgua alto =  new RequerimientosAgua(3l,"Alto");
        
                tRequerimientosAgua=Arrays.asList(bajo, medio, alto);
        
                return repository.saveAll(tRequerimientosAgua);
            }
        } catch (Exception e) {

        }

       return null;
    }

    @GetMapping("/requerimientos-agua")
    public List<RequerimientosAgua> mostrarRequerimientosAgua(){
        return repository.findAll();
    }
}
