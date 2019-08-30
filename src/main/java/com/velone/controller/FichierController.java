package com.velone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Fichier;
import com.velone.service.FichierService;

@CrossOrigin
@RestController
@RequestMapping("/fichiers")
public class FichierController {

	@Autowired
	FichierService serviceFichier;

	@GetMapping("/{id}")
	public Fichier getFichierById(@PathVariable(required = true) Integer id) {
		return serviceFichier.getFichierById(id);
	}

	@GetMapping("messageId/{id}")
	public List<Fichier> getFichierByMessageId(@PathVariable(required = true) Integer id) {
		return serviceFichier.getFichierByMessageId(id);
	}

	@PostMapping
	public void addFile(Fichier fichier) {
		serviceFichier.addFichier(fichier);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(required = true) Integer id) {
		serviceFichier.deleteFileById(id);
	}

	@GetMapping("trajetId/{id}")
	public List<Fichier> getAllFichierInTrajet(@PathVariable(required = true) Integer id) {
		return serviceFichier.getAllFIchierInTrajet(id);

	}

}
