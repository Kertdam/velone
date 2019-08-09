package com.velone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Utilisateur;
import com.velone.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired UtilisateurService service;

	@GetMapping
	public List<Utilisateur> getUsers() {
		return service.getUsers();
	}

	@PostMapping
	public void postUtilisateurEntity(@RequestBody Utilisateur user) {
		service.add(user);
	}

	@GetMapping("/{id}")
	public Optional<Utilisateur> getById(@PathVariable(required = true) Integer id) {
		return service.getUtilisateurById(id);
	}
	
	@GetMapping("/{nom}/{prenom}")
	public List<Utilisateur> getByNomOrPrenom(@PathVariable String nom,@PathVariable String prenom) {
		System.out.println("Controller "+nom+"   "+prenom);
		return service.getUtilisateurByNomOrPrenom(nom,prenom);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable(required = true)Integer id, @RequestBody Utilisateur user){
		service.update(id,user);
	}
	
}