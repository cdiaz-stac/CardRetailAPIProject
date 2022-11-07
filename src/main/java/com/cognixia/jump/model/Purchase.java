package com.cognixia.jump.model;

import javax.validation.constraints.NotBlank;

public class Purchase {

	@NotBlank
	private String orderId;
	
	@NotBlank
	private int qty;
	
	public Purchase() {
		
	}

	public Purchase(@NotBlank String orderId, @NotBlank int qty) {
		super();
		this.orderId = orderId;
		this.qty = qty;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Purchase [orderId=" + orderId + ", qty=" + qty + "]";
	}
	
	
	
}
