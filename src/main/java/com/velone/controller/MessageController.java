package com.velone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velone.entity.Message;
import com.velone.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService service;

	// OK
	@PostMapping
	public void postMessageEntity(@RequestBody Message message) {
		service.add(message);
	}

	// OK
	@GetMapping
	public List<Message> getAllMessages() {
		return service.getAllMessages();
	}

	// OK
	@GetMapping("/{id}")
	public Message getMessageById(@PathVariable(required = true) Integer id) {
		return service.getMessageById(id);
	}

	// OK
	@GetMapping("membreid/{id}")
	public List<Message> getMessageByMembreId(@PathVariable(required = true) Integer id) {
		return service.getMessageByMembreId(id);
	}

	// OK
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(required = true) Integer id) {
		service.delete(id);
	}

	@GetMapping("idtrajet/{id}")
	public void getAllMessageInTrajet(@PathVariable(required = true) Integer id) {
		service.getAllMessageInTrajet(id);
	}

}
