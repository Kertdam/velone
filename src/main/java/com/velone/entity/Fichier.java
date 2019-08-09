package com.velone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fichier")
public class Fichier {
	enum typeFichier {AUDIO, VIDEO, PHOTO}	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="type_fichier")
	@Enumerated(EnumType.STRING)
	private typeFichier type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="message_id")
	private Message message;
	
	
	/*Constructeurs*/
	
	public Fichier() {
		
	}

	/*Getters*/
	
	public Integer getId() {
		return id;
	}


	public typeFichier getType() {
		return type;
	}


	public Message getMessage() {
		return message;
	}
	
	/*Setters*/

	public void setId(Integer id) {
		this.id = id;
	}


	public void setType(typeFichier type) {
		this.type = type;
	}


	public void setMessage(Message message) {
		this.message = message;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fichier [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}	
	
	
}
