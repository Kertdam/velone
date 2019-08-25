package com.velone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velone.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
