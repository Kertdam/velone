package com.velone.service;

import java.util.List;

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

	public List<Membre> getMembres() {
		return repository.findAll();
	}

	public List<Membre> getByTrajetId(Integer id) {
		return repository.findByTrajetId(id);
	}

	/*
	 * public List<Membre> getTrajetById(Integer id) { // TODO Auto-generated method
	 * stub return repository.getTrajetsByUtilisateurId(id);
	 *
	 * }
	 */
	public List<Membre> getByUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return repository.findAllByUtilisateur(utilisateur);
	}

	public List<Membre> getByMembreId(Integer id) {

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

	/*
	 * public void delete(Integer utilisateur_id, Integer trajet_id) { // TODO
	 * Auto-generated method stub repository.deleteByUtilisateurIdAndTrajetId( );
	 * //repository.deleteByUtilisateurAndTrajetId(utilisateur_id,trajet_id);
	 *
	 * }
	 */

}