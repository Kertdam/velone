package com.velone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Statistique;

@Repository
public interface StatistiqueRepository extends JpaRepository<Statistique, Integer> {

	//Statistique findByMembreId(int id_user);

}
