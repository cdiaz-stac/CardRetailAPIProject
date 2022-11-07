package com.cognixia.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Cards;
import com.cognixia.jump.repository.CardsRepository;

@Service
public class CardsService {
	
	@Autowired
	CardsRepository repo;
	
	public List<Cards> getAllCards(){
		return repo.findAll();
	}
	
	
}
