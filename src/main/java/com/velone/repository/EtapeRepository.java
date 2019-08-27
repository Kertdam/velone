package com.velone.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.velone.entity.Etape;

@Repository
public interface EtapeRepository extends JpaRepository <Etape, Integer> {

	List <Etape> findByTrajetId(Integer id);

}
