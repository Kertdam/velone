package com.velone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Message;
import com.velone.repository.MessageRepository;
import com.velone.repository.TrajetRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repository;

	TrajetRepository repoTrajet;

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

	// Get All Message In Membre
	// public List<Message> getAllMessageInTrajet(Integer id) {

	// if(repoTrajet.existsById(id)) {

	// }
	// return ;

	// }

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
