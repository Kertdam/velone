package com.velone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Equipement;
import com.velone.entity.Membre;
import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;
import com.velone.service.EquipementService;
import com.velone.service.MembreService;

@RestController
@RequestMapping("/membre")
public class MembreController {

	@Autowired
	MembreService service;
	

	@GetMapping("")
	public List<Membre> getMembre() {
		return service.getMembres();
	}


	@GetMapping("/{id}")
	public List<Membre> getMembreById(@PathVariable(required = true) Integer id) {
		return service.getByMembreId(id);
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}
	@PutMapping("/{id}")
	public void update(@PathVariable(required = true)Integer id, @RequestBody Membre membre){
		service.update(id,membre);
	}
}
