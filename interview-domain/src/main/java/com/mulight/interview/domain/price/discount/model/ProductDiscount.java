package com.mulight.interview.domain.price.discount.model;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulight.interview.infrastructure.discount.model.DiscountModel;
import com.mulight.interview.infrastructure.discount.repository.DiscountRepository;

@Component
public class ProductDiscount {

	@Autowired
	private DiscountRepository discountRepository;
	
	public List<DiscountModel> fetchProductDiscount(Set<Integer> productList){
		
		return discountRepository.fetchProductDiscount(productList);
	}
	
}
