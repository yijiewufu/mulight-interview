package com.mulight.interview.infrastructure.price.model;

public class PriceModel {
	
	private Integer price;
	
	private Integer productId;

	// it should not be here 
	public PriceModel(Integer price, Integer productId) {
		super();
		this.price = price;
		this.productId = productId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	

}
