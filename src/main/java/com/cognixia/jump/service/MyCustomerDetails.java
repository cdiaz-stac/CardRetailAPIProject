package com.cognixia.jump.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.model.Customer;

// UserDetails -> used by spring security to find all the NECESSARY info for authorization & authentication
public class MyCustomerDetails implements UserDetails{
	
	private static final long serialVersionUID =1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	public MyCustomerDetails(Customer customer) {
		this.username = customer.getUsername();
		this.password = customer.getPassword();
		this.enabled = customer.isEnabled();
		
		// Granted Authority -> list of things we can do, permissions/grants a user has
		//					 -> find what a user's GA is by their roles
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(customer.getRole().name()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
