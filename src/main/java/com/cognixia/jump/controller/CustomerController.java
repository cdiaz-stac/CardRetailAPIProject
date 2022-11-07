package com.cognixia.jump.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;
import com.cognixia.jump.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	// @Valid -> always make sure validation is being checked, if it is not here it may let
	// 			 the value through
	@PostMapping("/customer")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
		customer.setId(null);
		
		// each password for a new user gets encoded
		customer.setPassword(encoder.encode(customer.getPassword()));
		
		Customer created = repo.save(customer);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable String id) throws ResourceNotFoundException{
		
		Customer found = service.findCustomerById(id);
		
		return ResponseEntity.status(200).body(found);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer) throws ResourceNotFoundException{
		
		Customer updated = service.updateCustomer(customer);
		
		return ResponseEntity.status(200).body(updated);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String id) throws ResourceNotFoundException{
		
		Customer deleted = service.deleteCustomer(id);
		
		return ResponseEntity.status(200).body(deleted);
	}
	
	@GetMapping("/customer/email/{email}")
	public List<Customer> findByEmail(@PathVariable String email){
		
		return repo.findByEmailIgnoreCase(email);
	}
	
}
