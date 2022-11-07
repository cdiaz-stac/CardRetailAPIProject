package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognixia.jump.model.Cards;

public interface CardsRepository extends MongoRepository<Cards, String>{
	
	// not case sensitive
	public List<Cards> findByCardnameIgnoreCase(String name);

}
