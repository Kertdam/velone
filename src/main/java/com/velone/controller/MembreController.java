package com.velone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//	@GetMapping("/trajet")
//	public List<Membre> getMembrebytrajet(@RequestBody Trajet entity){
//		return service.getByTrajet(entity);
//	}
	
	@GetMapping("trajet/{id}")
	public List<Membre> getTrajetById(@PathVariable(required = true) Integer id) {
		return service.getByTrajetId(id);
	}
	
	@GetMapping("utilisateur/{id}")
	public List<Membre> getUtilisateurById(@PathVariable(required = true) Integer id) {
		return service.getByUtilisateurId(id);
	}
	
	
//	@GetMapping("/utilisateur")
//	public List<Membre> getMembrebyUtilisateur(@RequestBody Utilisateur utilisateur){
//		return service.getByUtilisateur(utilisateur);
//	}
	
}
