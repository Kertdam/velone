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

import com.velone.entity.Etape;
import com.velone.service.EtapeService;

@RequestMapping("/etape")
@RestController
public class EtapeController{
	
	@Autowired EtapeService service; 
	
	@GetMapping("")
	public List<Etape> getEtapes() {
		return service.getEtapes();
	}

	@PostMapping ("")
	public void postEtapeEntity(@RequestBody Etape etape) {
		service.add(etape);	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.Delete(id);
	}
	
	@GetMapping ("/{id}")
	public Etape getEtapeById(@PathVariable(required = true) Integer id) {
		return service.getEtape(id) ;	
	}
	
	@GetMapping("idEtape/{id}")
	public List <Etape> getEtapeByIdTrajet(@PathVariable(required = true) Integer id) {
		return service.getEtapeByTrajetId(id);
	}
	@PutMapping("/{id}") 
	public void update (@PathVariable(required = true)Integer id, @RequestBody Etape etape ) {
		service.update(id, etape);
	}
}
