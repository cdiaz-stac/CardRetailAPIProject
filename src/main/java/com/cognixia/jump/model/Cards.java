package com.cognixia.jump.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class Cards {
	
	@NotBlank
	private String price;
	
	@NotBlank
	private String inventory;
	
	@NotBlank
	private String cardname;
	
	@Valid
	private Statistics statistics;
	
	public Cards() {
		
	}

	public Cards(@NotBlank String price, @NotBlank String inventory, @NotBlank String cardname,
			@Valid Statistics statistics) {
		super();
		this.price = price;
		this.inventory = inventory;
		this.cardname = cardname;
		this.statistics = statistics;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	@Override
	public String toString() {
		return "Cards [price=" + price + ", inventory=" + inventory + ", cardname=" + cardname + ", statistics="
				+ statistics + "]";
	}
	
}
