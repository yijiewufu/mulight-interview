package com.mulight.interview.infrastructure.price.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mulight.interview.infrastructure.price.model.PriceModel;

@Repository
public class PriceRepository {
	
	/**
	 * @param productSet set of product id;
	 * @return normal price of product;
	 * pretend we query it from DB using ibatis, and return all four watches each invoke;
	 */
	public List<PriceModel> fetchProductPrice(Set<Integer> productSet){
		
		List<PriceModel> watchList = new ArrayList<>();
		
		//suppose we get these from db
		PriceModel Rolex = new PriceModel(100,001);
		PriceModel MichaelKors = new PriceModel(80,002);
		PriceModel Swatch = new PriceModel(50,003);
		PriceModel Casio = new PriceModel(30,004);
		
		watchList.add(Rolex);
		watchList.add(MichaelKors);
		watchList.add(Swatch);
		watchList.add(Casio);
		
		return watchList;
		
	}

}
