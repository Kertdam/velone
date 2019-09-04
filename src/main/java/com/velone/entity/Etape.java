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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "etape")
public class Etape {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="lattitude")
	private Double lattitude;
	
	@Column(name="longitude")
	private Double longitude;
	
	@Column(name="elevation")
	private Double elevation;
	
	@Column(name="numero")
	private Integer numero;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="trajet_id")
	private Trajet trajet;

	/*Setters*/
	
	public Etape() {
		
	}
	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getElevation() {
		return elevation;
	}

	public Integer getNumero() {
		return numero;
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

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	/*ToString*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etape [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", lattitude=");
		builder.append(lattitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", elevation=");
		builder.append(elevation);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", trajet=");
		builder.append(trajet);
		builder.append("]");
		return builder.toString();
	}
	
}
