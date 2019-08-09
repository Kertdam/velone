package com.velone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point_interet")
public class PointInteret {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="description")
	private String description;
	
	@Column(name="lattitude")
	private Double lattitude;
	
	@Column(name="longitude")
	private Double quantite;
	
	@Column(name="elevation")
	private Double elevation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="utilisateur_id")
	private Utilisateur utilisateur;

	
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

	public Double getLattitude() {
		return lattitude;
	}

	public Double getQuantite() {
		return quantite;
	}

	public Double getElevation() {
		return elevation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
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

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointInteret [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", description=");
		builder.append(description);
		builder.append(", lattitude=");
		builder.append(lattitude);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", elevation=");
		builder.append(elevation);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
	
}
	
	