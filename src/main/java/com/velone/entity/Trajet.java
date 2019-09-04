package com.velone.entity;

import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "trajet")
public class Trajet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="description")
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="date_depart")
	private Date dateDepart;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="utilisateur_id")
	private Utilisateur utilisateur;
	
	@JsonManagedReference
	@OneToMany(mappedBy="trajet",cascade = CascadeType.ALL,orphanRemoval = true)
	@OrderBy("numero ASC")
    private Set<Etape> etapes;
	
	@JsonIgnore
	@OneToMany(mappedBy="trajet",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Equipement> equipements;
	
	@JsonIgnore
	@OneToMany(mappedBy="trajet",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Membre> membre;
	
	/*Constructeurs*/
	
	public Trajet() {
		
	}
	
	public Trajet(int id, String nom, String desc, Date dateDep, Utilisateur user) {
		this.id = id ;
		this.nom= nom ;
		this.description=desc;
		this.dateDepart=dateDep;
		this.utilisateur=user ;
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

	public Date getDateDepart() {
		return dateDepart;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/*Setters*/
	
	public Set<Etape> getEtapes() {
		return etapes;
	}

	public Set<Equipement> getEquipements() {
		return equipements;
	}

	public Set<Membre> getMembre() {
		return membre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setEtapes(Set<Etape> etapes) {
		this.etapes = etapes;
	}

	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	public void setMembre(Set<Membre> membre) {
		this.membre = membre;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trajet [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDepart=");
		builder.append(dateDepart);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append(", etapes=");
		builder.append(etapes);
		builder.append(", equipements=");
		builder.append(equipements);
		builder.append(", membre=");
		builder.append(membre);
		builder.append("]");
		return builder.toString();
	}

}
