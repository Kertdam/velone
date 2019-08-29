package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Equipement;
import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;
import com.velone.repository.EquipementRepository;
import com.velone.repository.TrajetRepository;

@Service
public class EquipementService {
	@Autowired
	EquipementRepository repository;

	public void add(Equipement equipement) {
		repository.save(equipement);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Equipement> getEq() {
		return repository.findAll();
	}

	public List<Equipement> getEquipementByNom(String nom) {
		return repository.findByNomContainsIgnoreCase(nom);
	}

	public Optional<Equipement> getEquipementById(Integer id) {
		return repository.findById(id);
	}

	public void update(Integer id, Equipement equipement) {
		Equipement equipementToUpdate = repository.getOne(id);
		equipementToUpdate.setNom(equipement.getNom());
		equipementToUpdate.setDescription(equipement.getDescription());
		equipementToUpdate.setQuantite(equipement.getQuantite());
		equipementToUpdate.setQuantiteInitiale(equipement.getQuantiteInitiale());
		equipementToUpdate.setTrajet(equipement.getTrajet());

		repository.save(equipementToUpdate);
		
	}
	public List<Equipement> getByTrajetId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findByTrajetId(id);
	}

}
