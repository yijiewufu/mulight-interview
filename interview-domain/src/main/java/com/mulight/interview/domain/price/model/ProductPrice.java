package com.mulight.interview.domain.price.model;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulight.interview.infrastructure.price.model.PriceModel;
import com.mulight.interview.infrastructure.price.repository.PriceRepository;

@Component
public class ProductPrice {

	@Autowired
	private PriceRepository priceRepository;
	
	public List<PriceModel> fetchProductPrice(Set<Integer> productList) {
		
		return priceRepository.fetchProductPrice(productList);
	}
}
