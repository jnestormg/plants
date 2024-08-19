package com.catalog.plants.plants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.plants.plants.entities.RequerimientosLuz;

@Repository
public interface requerimientosLuzRepository extends JpaRepository<RequerimientosLuz, Long> {

}
