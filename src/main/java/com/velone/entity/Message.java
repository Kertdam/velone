package com.velone.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
public class Message {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="texte")
	private String texte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="membre_id")
	private Membre membre;
	
	@JsonIgnoreProperties("message")
	@OneToMany(mappedBy="message",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Fichier> fichiers;

	/*Constructeurs*/
	
	public Message() {
		
	}
	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}

	public String getTexte() {
		return texte;
	}

	public Membre getMembre() {
		return membre;
	}

	/*Setters*/
	
	public Set<Fichier> getFichiers() {
		return fichiers;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public void setFichiers(Set<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", texte=");
		builder.append(texte);
		builder.append(", membre=");
		builder.append(membre);
		builder.append(", fichiers=");
		builder.append(fichiers);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
