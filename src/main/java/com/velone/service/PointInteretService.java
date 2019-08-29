package com.velone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.PointInteret;
import com.velone.repository.PointInteretRepository;

@Service
public class PointInteretService {

	@Autowired
	PointInteretRepository repository;

	public void add(PointInteret pointInteret) {
		repository.save(pointInteret);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<PointInteret> getPointsInteret() {
		return repository.findAll();
	}

	public PointInteret getPointInteretById(Integer id) {
		return repository.getOne(id);
	}

	public List<PointInteret> getPointInteretByUtilisateurId(Integer id) {
		return repository.findByUtilisateur(id);
	}

	public void update(Integer id, PointInteret pointInteret) {
		PointInteret pointInteretToUpdate = repository.getOne(id);
		pointInteretToUpdate.setDescription(pointInteret.getDescription());
		pointInteretToUpdate.setElevation(pointInteret.getElevation());
		pointInteretToUpdate.setId(pointInteret.getId());
		pointInteretToUpdate.setLattitude(pointInteret.getLattitude());
		pointInteretToUpdate.setNom(pointInteret.getNom());
		pointInteretToUpdate.setQuantite(pointInteret.getQuantite());
		pointInteretToUpdate.setUtilisateur(pointInteret.getUtilisateur());

	}

}
