package com.velone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Fichier;
import com.velone.repository.FichierRepository;

@Service
public class FichierService {

	@Autowired
	FichierRepository repoFichier;

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

}
