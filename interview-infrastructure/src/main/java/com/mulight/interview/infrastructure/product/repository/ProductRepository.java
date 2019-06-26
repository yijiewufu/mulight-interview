package com.mulight.interview.infrastructure.product.repository;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mulight.interview.infrastructure.product.model.ProductModel;

@Repository
public class ProductRepository {
	
	
	/**
	 * @param productList set of product ids;
	 * @return product models
	 */
	public List<ProductModel> fetchProducts(Set<Integer> productSet){
		//since we do not need to display product details in front end
		return null;
	}

}
