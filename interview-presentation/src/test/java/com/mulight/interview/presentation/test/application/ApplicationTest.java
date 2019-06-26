package com.mulight.interview.presentation.test.application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mulight.interview.application.checkout.CheckoutService;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private CheckoutService checkoutService;
	
	
	private List<Integer> inputList = new ArrayList<>();
	
	@Before
	public void prepare() {
		inputList.add(001);
	}
	
	@Test
	public void checkoutServiceTest() {
		BigInteger result = checkoutService.checkout(inputList);
		TestCase.assertEquals(0, result.compareTo(new BigInteger("100")));
	}
	
	@After
	public void afterTest() {
		System.out.println("do something after");
	}
}
