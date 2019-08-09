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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.velone.entity.Fichier.typeFichier;
@Entity
@Table(name = "membre")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Membre {	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="trajet_id")
	private Trajet trajet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="utilisateur_id")
	private Utilisateur utilisateur;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="membre",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Message> messages;
	
	@JsonIgnore
	@OneToOne (fetch = FetchType.LAZY, mappedBy="membre",cascade = CascadeType.ALL,orphanRemoval = true)
    private Statistique stat;
	
	/*Constructeurs*/
	
	public Membre() {
		
	}
	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/*Setters*/
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Membre [id=");
		builder.append(id);
		builder.append(", trajet=");
		builder.append(trajet);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
	
	
}
