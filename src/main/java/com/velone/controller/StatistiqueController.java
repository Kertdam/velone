package com.velone.controller;

import java.util.List;

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

import com.velone.entity.Statistique;
import com.velone.entity.Trajet;
import com.velone.service.StatistiqueService;


@CrossOrigin
@RestController
@RequestMapping("/statistique")
public class StatistiqueController {
	
	@Autowired 
	StatistiqueService service;
	
	@GetMapping
	public List<Statistique> getAllStatistique() {
		return service.getStatistiques();
	}
	
	@PostMapping
	public void postStatistiqueEntity(@RequestBody Statistique stat) {
		service.add(stat);
	}
	
	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable(required = true)Integer id, @RequestBody Statistique stat){
		service.update(id, stat);
	}
	
	@GetMapping("idmembre/{id}")
	public List<Statistique> getStatistiqueByMembreId(@PathVariable(required = true)Integer id) {
		return service.getStatistiqueByMembreId(id);
	}

}
