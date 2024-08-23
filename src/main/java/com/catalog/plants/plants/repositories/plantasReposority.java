package com.catalog.plants.plants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catalog.plants.plants.entities.Plantas;
import java.util.List;


@Repository
public interface plantasReposority extends JpaRepository<Plantas, Long>{

List<Plantas> findByNombre(String nombre);

List<Plantas> findByNombreContaining(String nombre);

@Query("SELECT p FROM Plantas p WHERE p.nombre ILIKE %:nombre%")
List<Plantas> buscarPorNombreLikeAdvance(@Param("nombre") String nombre);


}
