package com.velone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	List<Message> findByMembreId(Integer id);

}
