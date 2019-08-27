package com.velone.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velone.entity.Etape;
import com.velone.repository.EtapeRepository;

@Service
public class EtapeService {
	@Autowired
	EtapeRepository repository;
	public void add (Etape etape) {
		repository.save(etape);	
	}
	public void Delete(Integer id) {
		repository.deleteById(id);
	}
	public List<Etape> getEtapes(){
		 return repository.findAll();	
	}
	public Etape getEtape(Integer id){
		 return repository.getOne(id);	
	}
	public List<Etape> getEtapeByTrajetId(Integer id) {
		return repository.findByTrajetId(id);
	}
	
	public void update (Integer id, Etape etape) {	
	Etape etapeToUpdate = repository.getOne(id);
	etapeToUpdate.setElevation(etape.getElevation());
	etapeToUpdate.setLattitude(etape.getLattitude());
	etapeToUpdate.setId(etape.getId());
	etapeToUpdate.setLongitude(etape.getLongitude());
	etapeToUpdate.setNom(etape.getNom());
	etapeToUpdate.setNumero(etape.getNumero());
	etapeToUpdate.setTrajet(etape.getTrajet());
	}
	
	
	

	
}
