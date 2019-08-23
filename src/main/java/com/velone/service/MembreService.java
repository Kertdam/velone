package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Equipement;
import com.velone.entity.Membre;
import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;
import com.velone.repository.EquipementRepository;
import com.velone.repository.MembreRepository;


@Service
public class MembreService {
	@Autowired
	MembreRepository repository;


public List<Membre> getMembres(){
	return repository.findAll();
}
public List<Membre> getByTrajetId(Integer id){
	return repository.findByTrajetId(id);
}
/*public List<Membre> getTrajetById(Integer id) {
	// TODO Auto-generated method stub
	 return repository.getTrajetsByUtilisateurId(id);
	
}*/
public List<Membre> getByUtilisateur(Utilisateur utilisateur) {
	// TODO Auto-generated method stub
	return repository.findAllByUtilisateur(utilisateur);
}
public List<Membre> getByUtilisateurId(Integer id) {
	// TODO Auto-generated method stub
	return repository.findByUtilisateurId(id);
}
}