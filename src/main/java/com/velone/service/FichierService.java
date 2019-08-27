package com.velone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Fichier;
import com.velone.entity.Membre;
import com.velone.repository.FichierRepository;
import com.velone.repository.MembreRepository;

@Service
public class FichierService {

	@Autowired
	FichierRepository repoFichier;
	@Autowired
	MembreRepository repoMembre;

	public void addFichier(Fichier fichier) {
		repoFichier.save(fichier);
	}

	public void deleteFileById(Integer id) {
		repoFichier.deleteById(id);
	}

	public Fichier getFichierById(Integer id) {
		return repoFichier.getOne(id);
	}

	public List<Fichier> getFichierByMessageId(Integer id) {
		return repoFichier.findAllByMessageId(id);

	}

	public List<Fichier> getAllFIchierInTrajet(Integer id_trajet) {
		List<Membre> list = repoMembre.findByTrajetId(id_trajet);
		List<Integer> listId = new ArrayList<Integer>();
		for (Membre membre : list) {
			listId.add((membre.getId()));
		}
		return repoFichier.findAllByMessageIdIn(listId);
	}

}
