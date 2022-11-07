package com.cognixia.jump.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;

@Service
public class MyCustomerDetailsService implements UserDetailsService{
	
	@Autowired
	CustomerRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<Customer> cust = repo.findByUserNameIgnoreCase(username);
		
		if(cust.isEmpty()) {
			throw new UsernameNotFoundException("User with username " + username + " not found");
		}
		
		// as long as user is found, we return the object as a userdetails one;
		// userdetails will have only the necessary info for spring security
		return new MyCustomerDetails(cust.get());
	}
}
