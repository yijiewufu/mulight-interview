package com.mulight.interview.infrastructure.discount.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mulight.interview.infrastructure.discount.model.DiscountModel;

@Repository
public class DiscountRepository {

	/**
	 * @param productSet : set of product id
	 * @return all the discount detail if the product in the list has discount
	 */
	public List<DiscountModel> fetchProductDiscount(Set<Integer> productList) {

		List<DiscountModel> watchDiscountList = new ArrayList<>();

		// suppose we get these from db
		DiscountModel RolexDiscount = new DiscountModel(001, 3, 200);
		DiscountModel MichaelKorsDiscount = new DiscountModel(002, 2, 120);

		watchDiscountList.add(RolexDiscount);
		watchDiscountList.add(MichaelKorsDiscount);

		return watchDiscountList;
	}

}
