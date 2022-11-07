package com.cognixia.jump.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cognixia.jump.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	// this is not case sensitive
	public Optional<Customer> findByUserNameIgnoreCase(String customer);
	
	public List<Customer> findByEmailIgnoreCase(String customer);
	
	// json filter to find users with the same credit card
	@Query("{'billing.type': {$regex: '^?0', $options: 'i'}}")
	List<Customer> sameCreditCard(String card);

	// json filter to find users who bought the same card
	@Query ("{'cards.cardname': {$regex: '^?0', $options: 'i'}}")
	List<Customer> samePlayingCard(String card);

}
