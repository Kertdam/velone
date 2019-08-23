package com.velone.entity;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "equipement")
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantite")
	private Integer quantite;
	
	@Column(name="quantite_initiale")
	private Integer quantiteInitiale;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="trajet_id")
	private Trajet trajet;

	/*Constructeurs*/
	
	public Equipement() {
		
	}
	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getDescription() {
		return description;
	}


	public Integer getQuantite() {
		return quantite;
	}


	public Integer getQuantiteInitiale() {
		return quantiteInitiale;
	}


	public Trajet getTrajet() {
		return trajet;
	}

	/*Setters*/

	public void setId(Integer id) {
		this.id = id;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}


	public void setQuantiteInitiale(Integer quantiteInitiale) {
		this.quantiteInitiale = quantiteInitiale;
	}


	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	/*
	 *  ToString
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipement [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", description=");
		builder.append(description);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", quantiteInitiale=");
		builder.append(quantiteInitiale);
		builder.append(", trajet=");
		builder.append(trajet);
		builder.append("]");
		return builder.toString();
	}
	
}
