package com.velone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Fichier;

@Repository
public interface FichierRepository extends JpaRepository<Fichier, Integer> {

}
