package com.mulight.interview.infrastructure.discount.model;

public class DiscountModel {
	
	private Integer productId;
	
	private Integer discountAmoutUnit;
	
	private Integer dicountUnitPrice;

	public Integer getDiscountAmoutUnit() {
		return discountAmoutUnit;
	}

	public void setDiscountAmoutUnit(Integer discountAmoutUnit) {
		this.discountAmoutUnit = discountAmoutUnit;
	}

	public Integer getDicountUnitPrice() {
		return dicountUnitPrice;
	}

	public void setDicountUnitPrice(Integer dicountUnitPrice) {
		this.dicountUnitPrice = dicountUnitPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	//should not be here 
	public DiscountModel(Integer productId, Integer discountAmoutUnit, Integer dicountUnitPrice) {
		super();
		this.productId = productId;
		this.discountAmoutUnit = discountAmoutUnit;
		this.dicountUnitPrice = dicountUnitPrice;
	}
	
	

}
