package com.catalog.plants.plants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requerimientos_agua")
public class RequerimientosAgua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requerimiento;

    
    public RequerimientosAgua() {
    }

    public RequerimientosAgua(Long id, String requerimiento) {
        this.id=id;
        this.requerimiento = requerimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequerimento() {
        return requerimiento;
    }

    public void setRequerimento(String requerimento) {
        this.requerimiento = requerimento;
    }

    
    
}
