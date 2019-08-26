package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Statistique;
import com.velone.entity.Trajet;

@Repository
public interface StatistiqueRepository extends JpaRepository<Statistique, Integer> {

	List<Statistique> findByMembreId(Integer id);

}
