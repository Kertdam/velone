package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Integer> {

	List<Trajet> findByUtilisateurId(Integer id);
	
	List<Trajet> findByNomContainsIgnoreCase(String nom);
	
}
