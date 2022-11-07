package com.cognixia.jump.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Customer.Role;
import com.cognixia.jump.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	// @Mock -> set up mock object, allow us to mock the repository methods
	@Mock
	private CustomerRepository repo;
	
	
	//service won't autowire the repos, only creating the repos
	// as mock objects
	@InjectMocks
	private CustomerService service;
	
	@Test
	void testGetAllCustomers() throws Exception{
		
		// ARRANGE -> get all info needed
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("idstring", "JaneDoe", "123", "JaneDoe@hotmail.com", Role.ROLE_USER, true, null, null));
		
		when(repo.findAll()).thenReturn(customers);
		// ACT -> perform the test
		
		List<Customer> result = service.getAllCustomers();
		
		// ASSERT -> did the test pass
		
		if(customers.size() != result.size()) {
			fail();
		}
	}
	
}
