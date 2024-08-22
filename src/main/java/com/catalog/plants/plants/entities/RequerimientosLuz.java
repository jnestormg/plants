package com.catalog.plants.plants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "requerimientos_luz")
@Entity
public class RequerimientosLuz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requerimiento;

    
    public RequerimientosLuz() {
    }

    public RequerimientosLuz(Long id, String requerimiento) {
        this.id=id;
        this.requerimiento = requerimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    
    


}
