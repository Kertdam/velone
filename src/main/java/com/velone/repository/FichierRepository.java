package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Fichier;

@Repository
public interface FichierRepository extends JpaRepository<Fichier, Integer> {

	List<Fichier> findAllByMessageId(Integer membreId);

}
