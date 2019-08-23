package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velone.entity.Membre;
import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;

public interface MembreRepository  extends JpaRepository<Membre, Integer> {
	public List<Membre> findAllByTrajet(Trajet entity);

//	public List<Membre> findUtilisateurById();

	//public List<Membre> getTrajetsByUtilisateurId(Integer id);

	//public List<Membre> findUtilisateurById();

	

	public List<Membre> findAllByUtilisateur(Utilisateur utilisateur);

	public List<Membre> findByTrajetId(Integer id);

	public List<Membre> findByUtilisateurId(Integer id);
}
