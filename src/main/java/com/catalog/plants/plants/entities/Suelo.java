package com.catalog.plants.plants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suelo")
public class Suelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo_suelo;

    
    public Suelo() {
    }

    public Suelo(Long id, String tipo_suelo) {
        this.id=id;
        this.tipo_suelo = tipo_suelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_suelo() {
        return tipo_suelo;
    }

    public void setTipo_suelo(String tipo_suelo) {
        this.tipo_suelo = tipo_suelo;
    }

    

}
