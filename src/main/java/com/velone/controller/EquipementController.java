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

import com.velone.entity.Equipement;
import com.velone.entity.Trajet;
import com.velone.entity.Utilisateur;
import com.velone.service.EquipementService;
import com.velone.service.UtilisateurService;


@RestController
@RequestMapping("/equipement")
public class EquipementController {

	@Autowired
	EquipementService service;
	
	@GetMapping()
	public List<Equipement> getEquipement() {
		return service.getEq();
	}
	
	@PostMapping
public void postEquipementEntity(@RequestBody Equipement equipement) {
	service.add(equipement);
}
	
	
	@GetMapping("/{id}")
	public Optional<Equipement> getEquipementById(@PathVariable(required = true) Integer id) {
		return service.getEquipementById(id);
	}
	

	
	@GetMapping("nom/{nom}")
	public List<Equipement> getEquipementByNom(@PathVariable(required = true) String nom) {
		return this.service.getEquipementByNom(nom);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable(required = true)Integer id, @RequestBody Equipement equipement){
		service.update(id,equipement);
	}
	@GetMapping("trajet/{id}")
	public List<Equipement> getEquipementByTrajetId(@PathVariable(required = true) Integer id) {
		return this.service.getByTrajetId(id) ;
	}

}
