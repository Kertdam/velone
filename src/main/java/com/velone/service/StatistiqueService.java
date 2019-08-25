package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Statistique;
import com.velone.repository.StatistiqueRepository;

@Service
public class StatistiqueService {

	@Autowired
	StatistiqueRepository repository;

	// CRUD ToTest

	public void add(Statistique stat) {
		repository.save(stat);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Statistique> getStatistiques() {
		return repository.findAll();
	}

	public void update(Integer id, Statistique stat) {
		Statistique statToUpdate = repository.getOne(id);
		statToUpdate.setVitesseMoyenne(stat.getVitesseMoyenne());
		statToUpdate.setTempsTrajet(stat.getTempsTrajet());
		statToUpdate.setDistance_parcourue(stat.getDistance_parcourue());
		statToUpdate.setAscension(stat.getAscension());
		statToUpdate.setAltitudeMax(stat.getAltitudeMax());
		statToUpdate.setKcalDepense(stat.getKcalDepense());
		statToUpdate.setMembre(stat.getMembre());
		repository.save(statToUpdate);
	}

	// Methode propres ToTest

	public List<Statistique> getStatistiqueByMembreId(int membre_id) {
		return repository.findByMembreId(membre_id);
	}

}
