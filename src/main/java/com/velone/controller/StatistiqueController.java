package com.velone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Statistique;
import com.velone.service.StatistiqueService;


@CrossOrigin
@RestController
@RequestMapping("/statistique")
public class StatistiqueController {
	
	@Autowired 
	StatistiqueService service;
	
	@GetMapping
	public List<Statistique> getStatistique() {
		return service.getStatistiques();
	}
	
	@PostMapping
	public void postStatistiqueEntity(@RequestBody Statistique stat) {
		service.add(stat);
	}

}
