package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Utilisateur;
import com.velone.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	UtilisateurRepository repository;

	public void add(Utilisateur user) {
		repository.save(user);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Utilisateur> getUsers() {
		return repository.findAll();
	}
	
	public Optional<Utilisateur> getUtilisateurById(Integer id) {
		return repository.findById(id);
	}

	public List<Utilisateur> getUtilisateurByNomOrPrenom(String nom, String prenom) {
		System.out.println(nom+"   "+prenom);
		return repository.findByNomOrPrenom(nom,prenom);
	}
	
	public void update(Integer id, Utilisateur user) {
		Utilisateur userToUpdate = repository.getOne(id) ;
		userToUpdate.setNom(user.getNom()); 
		userToUpdate.setPrenom(user.getPrenom());
		userToUpdate.setDateNaissance(user.getDateNaissance()); 
		userToUpdate.setAdresse(user.getAdresse()); 
		userToUpdate.setVille(user.getVille());
		userToUpdate.setCodePostal(user.getCodePostal()); 
		userToUpdate.setMail(user.getMail()); 
		userToUpdate.setPassword(user.getPassword()); 
		repository.save(userToUpdate);
	}
}
