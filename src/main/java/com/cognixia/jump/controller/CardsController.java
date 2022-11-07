package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Cards;
import com.cognixia.jump.repository.CardsRepository;
import com.cognixia.jump.service.CardsService;

@RestController
@RequestMapping("/api")
public class CardsController {
	
	@Autowired
	CardsService service;
	
	@Autowired
	CardsRepository repo;
	
	@GetMapping("/cards")
	public List<Cards> getAllCards(){
		return service.getAllCards();
	}
}
