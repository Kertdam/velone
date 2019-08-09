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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Utilisateur")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="code_postal")
	private String codePostal;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dateNaissance")
	private LocalDate dateNaissance;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="utilisateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Trajet> trajets;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="utilisateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Membre> membres;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="utilisateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<PointInteret> PointInterets;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="utilisateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ami> amis;
	
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="utilisateur2",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ami> amisOf;
	
	
	/*Code qui renvoie une liste d'utilisateur mais n'utilise pas d'entity
	 * @ManyToMany
	@JoinTable(name="utilisateur_utilisateur", joinColumns= {
		@JoinColumn(name="id_utilisateur_1", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="id_utilisateur_2", referencedColumnName="id")}
	)
    private Set<Utilisateur> amis;*/
	
	
	
	
	/*
	 * Constructeurs
	 */

	public Utilisateur() {
		
	}

	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getVille() {
		return ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Set<Trajet> getTrajets() {
		return trajets;
	}
	
	public Set<Ami> getAmis() {
		return amis;
	}
	
	public Set<Ami> getAmisOf() {
		return amisOf;
	}
	
	/*Setters*/

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setTrajets(Set<Trajet> trajets) {
		this.trajets = trajets;
	}
	
	public void setAmis(Set<Ami> amis) {
		this.amis=amis;
	}
	
	public void setAmisOf(Set<Ami> amisOf) {
		this.amisOf=amisOf;
	}
	
	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", password=");
		builder.append(password);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", trajets=");
		builder.append(trajets);
		builder.append("]");
		return builder.toString();
	}

}
