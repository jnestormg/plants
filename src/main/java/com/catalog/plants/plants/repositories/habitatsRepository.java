package com.catalog.plants.plants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.plants.plants.entities.Habitats;

@Repository
public interface habitatsRepository extends JpaRepository<Habitats, Long> {

}
