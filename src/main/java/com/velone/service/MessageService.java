package com.velone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velone.entity.Message;
import com.velone.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repository;

	// Add a message
	public void add(Message message) {
		repository.save(message);
	}

	// Delete a message by Id
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	// Get all
	public List<Message> getAllMessages() {
		return repository.findAll();
	}

	// Get one by id
	public Message getMessageById(Integer id) {
		return repository.getOne(id);
	}

	// update a message
	public void update(Integer id, Message mess) {
		Message messToUpdate = repository.getOne(id);
		messToUpdate.setTexte(mess.getTexte());
		repository.save(messToUpdate);
	}

	// Get by utilisateur
	public Optional<Message> getMessageByMembreId(Integer id) {
		return repository.findByMembreId(id);
	}
}
