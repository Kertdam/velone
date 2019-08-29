package com.velone.controller;

import java.util.List;

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
import com.velone.entity.PointInteret;
import com.velone.service.PointInteretService;

@RequestMapping("/pointInteret")
@RestController
public class PointInteretController {
	
     @Autowired PointInteretService service; 
	
	@GetMapping("")
	public List<PointInteret> get() {
		return service.getPointInterets();
	}
	@PostMapping ("")
	public void postPointInteretEntity(@RequestBody PointInteret pointInteret) {
		service.add(pointInteret);	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Integer id) {
		service.Delete(id);
	}
	@GetMapping("idUtilisateur/{id}")
	public List<PointInteret> getPointInteretByUtilisateur(@PathVariable(required = true) Integer id){
		return service.getPointInteretByUtilisateur(id);
	}
	@PutMapping("/{id}")
	 public void update(@PathVariable(required = true)Integer id, @RequestBody PointInteret pointInteret ){
		 service.update(id, pointInteret);	 
	 }
}
