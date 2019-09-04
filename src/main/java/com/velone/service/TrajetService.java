package com.velone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Membre;
import com.velone.entity.Trajet;
import com.velone.exception.ResourcesNotFoundException;
import com.velone.repository.TrajetRepository;

@Service
public class TrajetService {
	@Autowired
	TrajetRepository repository;
	@Autowired
	MembreService serviceMembre;

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

	public List<Trajet> getTrajetsByMembreId(Integer id) {

		List<Membre> listMembre = serviceMembre.getMembresByUtilisateurId(id);
		List<Integer> listTrajetId = new ArrayList<>();

		// Recup l'id des trajets dans la liste de membre
		for (Membre membre : listMembre) {
			Integer TrajetId = membre.getTrajet().getId();
			listTrajetId.add(TrajetId);
		}
		List<Trajet> listTrajet = new ArrayList<>();

		// Recup trajet grâce à la liste des TrajetId
		for (Integer trajetId : listTrajetId) {
			Trajet trajet = getTrajetById(trajetId)
					.orElseThrow(() -> new ResourcesNotFoundException("trajet", "id", trajetId));
			listTrajet.add(trajet);
		}
		return listTrajet;
	}

	public void updateById(Integer id, Trajet trajet) {
		Trajet trajetToUpdate = repository.getOne(id);
		trajetToUpdate.setNom(trajet.getNom());
		trajetToUpdate.setDescription(trajet.getDescription());
		trajetToUpdate.setDateDepart(trajet.getDateDepart());
		repository.save(trajetToUpdate);
	}
}
