package com.velone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Trajet;
import com.velone.service.TrajetService;

@CrossOrigin
@RestController
@RequestMapping("/trajets")
public class TrajetController {

	@Autowired
	TrajetService service;

	@GetMapping
	public List<Trajet> getTrajets() {
		return service.getTrajets();
	}

	@PostMapping
	public void postTrajetEntity(@RequestBody Trajet trajet) {
		service.add(trajet);
	}

	@GetMapping("/{id}")
	public Optional<Trajet> getById(@PathVariable(required = true) Integer id) {
		return service.getTrajetById(id);
	}

	@GetMapping("utilisateurId/{id}")
	public List<Trajet> getTrajetsByUtilisateurId(@PathVariable(required = true) Integer id) {
		return service.getTrajetsByUtilisateurId(id);
	}

	@GetMapping("nom/{nom}")
	public List<Trajet> getTrajetsByNom(@PathVariable(required = true) String nom) {
		return service.getTrajetsByNom(nom);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable(required = true) Integer id, @RequestBody Trajet trajet) {
		service.updateById(id, trajet);
	}

}