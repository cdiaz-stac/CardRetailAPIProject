package com.cognixia.jump.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// create a collection called customer and manage documents that look like this class
@Document
public class Customer implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	public static enum Role{
		ROLE_USER, ROLE_ADMIN
	}
	
	// mark the _id value that mongo will generate
	@Id
	private String id;
	
	@NotBlank(message = "The customer's user name must not be blank")
	private String username;
	
	@NotBlank(message = "The password must not be blank")
	private String password;
	
	@Indexed(unique = true)
	@NotBlank(message = "The email must not be blank")
	private String email;	
	
	// will store the role as a string in the db
	private Role role = Role.ROLE_ADMIN;
	
	private boolean enabled;
	
	// composition objects get marked with @valid if there is any validation to check
	@Valid
	private Billing billing;
	
	@Valid
	private Cards cards;
	
	public Customer() {
		
	}

	public Customer(String id, @NotBlank(message = "The customer's user name must not be blank") String username,
			@NotBlank(message = "The password must not be blank") String password,
			@NotBlank(message = "The email must not be blank") String email, Role role, boolean enabled,
			@Valid Billing billing, @Valid Cards cards) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
		this.billing = billing;
		this.cards = cards;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Cards getCards() {
		return cards;
	}

	public void setCards(Cards cards) {
		this.cards = cards;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", enabled=" + enabled + ", billing=" + billing + ", cards=" + cards + "]";
	}
	
	
}
