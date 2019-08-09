package com.velone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="utilisateur_utilisateur")
public class Ami {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	 
	@ManyToOne(optional=false)
	@JoinColumn(name="id_utilisateur_1", nullable=false)
	private Utilisateur utilisateur;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_utilisateur_2", nullable=false)
	private Utilisateur utilisateur2;

	/*Constructeurs*/
	
	public Ami() {
		
	}
	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public Utilisateur getUtilisateur2() {
		return utilisateur2;
	}
	
	/*Setters*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void setUtilisateur2(Utilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}

	/*ToString*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ami [id=");
		builder.append(id);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append(", utilisateur2=");
		builder.append(utilisateur2);
		builder.append("]");
		return builder.toString();
	}
	
	 
}