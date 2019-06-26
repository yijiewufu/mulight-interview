package com.mulight.interview.domain.inventory.model;

import java.util.Set;

import org.springframework.stereotype.Component;
@Component
public class ProductInventory {
	
	
	/**
	 * @param productTypeList, list of product id
	 * @return Boolean
	 * check purchasing list for each order from customer. Any product's amount is bigger than inventory left amount will return false
	 * and stop the order
	 */
	public Boolean checkInventory(Set<Integer> productTypeList) {
		
		//here we suppose we have unlimited amount for each product 
		return true;
	}

}
