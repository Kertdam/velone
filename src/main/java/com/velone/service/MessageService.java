package com.velone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Membre;
import com.velone.entity.Message;
import com.velone.repository.MembreRepository;
import com.velone.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repository;
	@Autowired
	MembreRepository repoMembre;

	// Add a message
	public void add(Message message) {
		repository.save(message);
	}

	// Delete a message by Id OK
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	// Get all OK
	public List<Message> getAllMessages() {
		return repository.findAll();
	}

	// Get one by id OK
	public Message getMessageById(Integer id) {
		return repository.getOne(id);
	}

	// Trouver tous les messages d'un trajet
	public List<Message> getAllMessageInTrajet(Integer id_trajet) {
		System.out.println("ahhhhhhhhhhh");
		List<Membre> list = repoMembre.findByTrajetId(id_trajet);
		List<Integer> listId = new ArrayList<Integer>();
		for (Membre membre : list) {
			System.out.println(membre.getId());
			listId.add((membre.getId()));
		}
		System.out.println(listId);

		return repository.findAllByMembreIdIn(listId);

	}

	// update a message
	public void update(Integer id, Message mess) {
		Message messToUpdate = repository.getOne(id);
		messToUpdate.setTexte(mess.getTexte());
		repository.save(messToUpdate);
	}

	// Get by membre OK
	public List<Message> getMessageByMembreId(Integer id) {
		return repository.findByMembreId(id);
	}
}
