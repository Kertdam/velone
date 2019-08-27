package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.PointInteret;

@Repository
public interface PointInteretRepository extends JpaRepository <PointInteret, Integer> {


	List<PointInteret> findByUtilisateur(Integer id);

}