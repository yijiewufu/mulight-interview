package com.mulight.interview.presentation.test.infrastructure;

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

import com.mulight.interview.infrastructure.discount.model.DiscountModel;
import com.mulight.interview.infrastructure.discount.repository.DiscountRepository;
import com.mulight.interview.infrastructure.price.model.PriceModel;
import com.mulight.interview.infrastructure.price.repository.PriceRepository;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfrastructureTest {
	
	@Autowired
	private DiscountRepository discountRepository;
	
	@Autowired
	private PriceRepository priceRepository;
	
	private Set<Integer> inputSet = new HashSet<>();
	
	@Before
	public void prepare() {
		inputSet.add(001);
	}
	
	@Test
	public void discountTest() {
		
		List<DiscountModel> discountList = discountRepository.fetchProductDiscount(inputSet);
		TestCase.assertEquals(2, discountList.size());
		
	}
	
	@Test
	public void priceTest() {
		List<PriceModel> priceList = priceRepository.fetchProductPrice(inputSet);
		TestCase.assertEquals(4, priceList.size());
		
	}
	
	@After
	public void afterTest() {
		System.out.println("do something after");
	}

}
