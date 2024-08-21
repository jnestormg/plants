package com.catalog.plants.plants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitat")
public class Habitats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_habitat;

    

    public Habitats() {
    }

    public Habitats(String nombre_habitat) {
        this.nombre_habitat = nombre_habitat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_habitat() {
        return nombre_habitat;
    }

    public void setNombre_habitat(String nombre_habitat) {
        this.nombre_habitat = nombre_habitat;
    }
    
}
