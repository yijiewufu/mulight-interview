package com.mulight.interview.presentation.test.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mulight.interview.domain.checkout.model.ProductCheckout;
import com.mulight.interview.domain.inventory.model.ProductInventory;
import com.mulight.interview.domain.price.discount.model.ProductDiscount;
import com.mulight.interview.domain.price.model.ProductPrice;
import com.mulight.interview.infrastructure.discount.model.DiscountModel;
import com.mulight.interview.infrastructure.discount.repository.DiscountRepository;
import com.mulight.interview.infrastructure.price.model.PriceModel;
import com.mulight.interview.infrastructure.price.repository.PriceRepository;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainTest {
	
	@Autowired
	private ProductCheckout productCheckout;
	
	@Autowired
	private ProductInventory productInventory;
	
	@Autowired
	private ProductDiscount productDiscount;
	
	@Autowired
	private ProductPrice productPrice;
	
	private Set<Integer> inputSet = new HashSet<>();
	
	private List<Integer> productList = new ArrayList<>();
	
	@Before
	public void prepare() {
		inputSet.add(001);
		productList.add(001);
	}
	
	@Test
	public void productCheckoutTest() {
		
		BigInteger result = productCheckout.checkout(productList);
		TestCase.assertEquals(0, result.compareTo(new BigInteger("100")));
		
	}
	
	@Test
	public void productDiscountTest() {
		List<DiscountModel> discountList = productDiscount.fetchProductDiscount(inputSet);
		TestCase.assertEquals(2, discountList.size());
		
	}
	
	@Test
	public void productInventoryTest() {
		
		Boolean result = productInventory.checkInventory(inputSet);
		TestCase.assertEquals(true, result.booleanValue());
		
	}
	
	@Test
	public void productPriceTest() {
		List<PriceModel> priceList = productPrice.fetchProductPrice(inputSet);
		TestCase.assertEquals(4, priceList.size());
		
	}
	
	@After
	public void afterTest() {
		System.out.println("do something after");
	}

}
