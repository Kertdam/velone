package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Trajet;
import com.velone.repository.TrajetRepository;


@Service
public class TrajetService {
	@Autowired
	TrajetRepository repository;

	public void add(Trajet trajet) {
		repository.save(trajet);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Trajet> getTrajets() {
		return repository.findAll();
	}
	
	public List<Trajet> getTrajetsByUtilisateurId(Integer id) {
		return repository.findByUtilisateurId(id);
	}
	
	public List<Trajet> getTrajetsByNom(String nom) {
		return repository.findByNomContainsIgnoreCase(nom);
	}
	
	public Optional<Trajet> getTrajetById(Integer id) {
		return repository.findById(id);
	}

	public void update(Integer id, Trajet trajet) {
		Trajet trajetToUpdate = repository.getOne(id) ;
		trajetToUpdate.setNom(trajet.getNom()); 
		trajetToUpdate.setDescription(trajet.getDescription());
		trajetToUpdate.setDateDepart(trajet.getDateDepart());
		repository.save(trajetToUpdate);
	}
}
