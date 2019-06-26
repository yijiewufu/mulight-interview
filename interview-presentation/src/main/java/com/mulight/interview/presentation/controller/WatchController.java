package com.mulight.interview.presentation.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mulight.interview.application.checkout.CheckoutService;
import com.mulight.interview.presentation.rop.response.CheckoutResponse;

@RestController
public class WatchController {
	
	@Autowired
	private CheckoutService checkoutService;

	@RequestMapping(value = "/checkout", method = RequestMethod.POST )
	@ResponseBody
	public CheckoutResponse watchCheckOut(@RequestBody List<String> requestList) {
		List<Integer> productList = requestList.parallelStream().map(str -> Integer.valueOf(str)).collect(Collectors.toList());
		BigInteger sum = checkoutService.checkout(productList);
		CheckoutResponse response = new CheckoutResponse();
		response.setPrice(sum);
		return response;
	}
	
}
