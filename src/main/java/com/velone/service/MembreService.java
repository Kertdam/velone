package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Membre;
import com.velone.entity.Utilisateur;
import com.velone.repository.MembreRepository;

@Service
public class MembreService {
	@Autowired
	MembreRepository repository;

	public void add(Membre membre) {
		repository.save(membre);
	}

	public List<Membre> getMembresByUtilisateurId(Integer id) {
		return repository.findAllByUtilisateurId(id);
	}

	public List<Membre> getMembres() {
		return repository.findAll();
	}

	public List<Membre> getByTrajetId(Integer id) {
		return repository.findByTrajetId(id);
	}

	public List<Membre> getByUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return repository.findAllByUtilisateur(utilisateur);
	}

	public List<Membre> getByUtilisateurId(Integer id) {
		return repository.findByUtilisateurId(id);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public void update(Integer id, Membre membre) {
		Membre membreToUpdate = repository.getOne(id);
		membreToUpdate.setId(id);
		membreToUpdate.setTrajet(membre.getTrajet());
		membreToUpdate.setUtilisateur(membre.getUtilisateur());
		repository.save(membreToUpdate);
	}

	public Optional<Membre> getByMembreId(Integer id) {

		return repository.findById(id);
	}
}