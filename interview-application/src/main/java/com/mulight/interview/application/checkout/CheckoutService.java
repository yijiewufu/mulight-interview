package com.mulight.interview.application.checkout;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulight.interview.domain.checkout.model.ProductCheckout;

@Service
public class CheckoutService {

	@Autowired
	private ProductCheckout productCheckout;
	
	public BigInteger checkout(List<Integer> productList) {
		return productCheckout.checkout(productList);
	}
}
