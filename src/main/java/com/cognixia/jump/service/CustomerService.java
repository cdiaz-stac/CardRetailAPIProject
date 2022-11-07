package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired 
	CustomerRepository repo;
	
	public List<Customer> getAllCustomers(){
		//findAll() -> returns all customers in the collection
		return repo.findAll();
	}
	
	public Customer findCustomerById(String id) throws ResourceNotFoundException{
		
		Optional<Customer> found = repo.findById(id);
		
		if(found.isPresent()) {
		
			//get() -> extract the object stored w/i the optional
			return found.get();
		}
		throw new ResourceNotFoundException("Customer", id);		
	}
	
	public Customer createCustomer(Customer customer) {
		customer.setId(null);
		
		//insert() -> always going to create a new document
		Customer created = repo.insert(customer);
		return created;
	}
	
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException{
		// save() -> performs an update as long as the id exists
		//        -> if id doesn't exist, will do an insert
		
		if(repo.existsById(null)) {
			Customer updated = repo.save(customer);
			return updated;
		}
		throw new ResourceNotFoundException("Customer", customer.getId());
	}
	
	public Customer deleteCustomer(String id) throws ResourceNotFoundException{
		Customer toDelete = findCustomerById(id);
		// won't run rest of code if customer isn't found(gets thrown)
		repo.deleteById(id);
		return toDelete;
	}
}
