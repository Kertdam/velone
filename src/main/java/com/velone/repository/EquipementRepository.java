package com.velone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velone.entity.Equipement;
import com.velone.entity.Trajet;

public interface EquipementRepository extends JpaRepository<Equipement, Integer> {
	
	List<Equipement> findByNomContainsIgnoreCase(String nom);
  
//	List<Equipement> findEquipementById(Integer id);
	List<Equipement> findByTrajetId(Integer id);

}
