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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statistique")
public class Statistique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="vitesse_moyenne")
	private Double vitesseMoyenne;
	
	@Column(name="ascension")
	private Integer ascension;
	
	@Column(name="temps_trajet")
	private Integer tempsTrajet;
	
	@Column(name="distance_parcourue")
	private Integer distance_parcourue;
	
	@Column(name="altitude_max")
	private Integer altitudeMax;
	
	@Column(name="altitude_min")
	private Integer altitudeMin;
	
	@Column(name="kcal_depensee")
	private Integer kcalDepense;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="membre_id")
	private Membre membre;

	
	/*Getters*/
	
	public Integer getId() {
		return id;
	}

	public Double getVitesseMoyenne() {
		return vitesseMoyenne;
	}

	public Integer getAscension() {
		return ascension;
	}

	public Integer getTempsTrajet() {
		return tempsTrajet;
	}

	public Integer getDistance_parcourue() {
		return distance_parcourue;
	}

	public Integer getAltitudeMax() {
		return altitudeMax;
	}

	public Integer getAltitudeMin() {
		return altitudeMin;
	}

	public Integer getKcalDepense() {
		return kcalDepense;
	}

	public Membre getMembre() {
		return membre;
	}

	/*Setters*/
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setVitesseMoyenne(Double vitesseMoyenne) {
		this.vitesseMoyenne = vitesseMoyenne;
	}

	public void setAscension(Integer ascension) {
		this.ascension = ascension;
	}

	public void setTempsTrajet(Integer tempsTrajet) {
		this.tempsTrajet = tempsTrajet;
	}

	public void setDistance_parcourue(Integer distance_parcourue) {
		this.distance_parcourue = distance_parcourue;
	}

	public void setAltitudeMax(Integer altitudeMax) {
		this.altitudeMax = altitudeMax;
	}

	public void setAltitudeMin(Integer altitudeMin) {
		this.altitudeMin = altitudeMin;
	}

	public void setKcalDepense(Integer kcalDepense) {
		this.kcalDepense = kcalDepense;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	/*ToString*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statistique [id=");
		builder.append(id);
		builder.append(", vitesseMoyenne=");
		builder.append(vitesseMoyenne);
		builder.append(", ascension=");
		builder.append(ascension);
		builder.append(", tempsTrajet=");
		builder.append(tempsTrajet);
		builder.append(", distance_parcourue=");
		builder.append(distance_parcourue);
		builder.append(", altitudeMax=");
		builder.append(altitudeMax);
		builder.append(", altitudeMin=");
		builder.append(altitudeMin);
		builder.append(", kcalDepense=");
		builder.append(kcalDepense);
		builder.append(", membre=");
		builder.append(membre);
		builder.append("]");
		return builder.toString();
	}
	
}
