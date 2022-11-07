package com.cognixia.jump.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

public class Billing implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@NotBlank
	private String type;
	
	//@CreditCardNumber Checks for real valid credit cards
	//@Pattern(regexp = "{$regex:d{16}}")
	private String cardnum;
	
	@DateTimeFormat(pattern = "YYYY/mm")
	private String expiry;

	public Billing() {
		
	}
	
	public Billing(@NotBlank String type, @CreditCardNumber String cardnum, String expiry) {
		super();
		this.type = type;
		this.cardnum = cardnum;
		this.expiry = expiry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "Billing [type=" + type + ", cardnum=" + cardnum + ", expiry=" + expiry + "]";
	}
	
	
}
