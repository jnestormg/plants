package com.catalog.plants.plants.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plantas")
public class Plantas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "foto")
    private String foto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "altura")
    private Float altura;

    @Column(name = "toxicidad")
    private Boolean toxicidad;

    @ManyToOne
    @JoinColumn(name = "id_requerimiento_luz")
    private RequerimientosLuz id_requerimiento_luz;

    @ManyToOne
    @JoinColumn(name = "id_habitat")
    private Habitats id_habitat;

    @ManyToOne
    @JoinColumn(name = "id_requerimiento_agua")
    private RequerimientosAgua id_requerimiento_agua;

    @ManyToOne
    @JoinColumn(name = "id_flor")
    private Flores id_flor;

    @ManyToOne
    @JoinColumn(name = "id_suelo")
    private Suelo id_suelo;

    @ManyToOne
    @JoinColumn(name = "id_familia")
    private familias id_familia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Boolean getToxicidad() {
        return toxicidad;
    }

    public void setToxicidad(Boolean toxicidad) {
        this.toxicidad = toxicidad;
    }

    public RequerimientosLuz getId_requerimiento_luz() {
        return id_requerimiento_luz;
    }

    public void setId_requerimiento_luz(RequerimientosLuz id_requerimiento_luz) {
        this.id_requerimiento_luz = id_requerimiento_luz;
    }

    public Habitats getId_habitat() {
        return id_habitat;
    }

    public void setId_habitat(Habitats id_habitat) {
        this.id_habitat = id_habitat;
    }

    public RequerimientosAgua getId_requerimiento_agua() {
        return id_requerimiento_agua;
    }

    public void setId_requerimiento_agua(RequerimientosAgua id_requerimiento_agua) {
        this.id_requerimiento_agua = id_requerimiento_agua;
    }

    public Flores getId_flor() {
        return id_flor;
    }

    public void setId_flor(Flores id_flor) {
        this.id_flor = id_flor;
    }

    public Suelo getId_suelo() {
        return id_suelo;
    }

    public void setId_suelo(Suelo id_suelo) {
        this.id_suelo = id_suelo;
    }

    public familias getId_familia() {
        return id_familia;
    }

    public void setId_familia(familias id_familia) {
        this.id_familia = id_familia;
    }

    

}
