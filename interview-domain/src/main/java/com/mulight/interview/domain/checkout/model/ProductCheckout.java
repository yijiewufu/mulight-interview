package com.mulight.interview.domain.checkout.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mulight.interview.domain.inventory.model.ProductInventory;
import com.mulight.interview.domain.price.discount.model.ProductDiscount;
import com.mulight.interview.domain.price.model.ProductPrice;
import com.mulight.interview.infrastructure.discount.model.DiscountModel;
import com.mulight.interview.infrastructure.price.model.PriceModel;

@Component
public class ProductCheckout {
	
	@Autowired
	private ProductInventory productInventory;
	
	@Autowired
	private ProductDiscount productDiscount;
	
	@Autowired
	private ProductPrice productPrice;
	
	public BigInteger checkout(List<Integer> productList) {
		
		BigInteger checkoutResult = new BigInteger("0");
		
		//
		ConcurrentHashMap<Integer, BigInteger> productCountsMap = new ConcurrentHashMap<>();
		BigInteger one = new BigInteger("1");
		productList.parallelStream().forEach(i -> {
			if(productCountsMap.containsKey(i)) {
				synchronized(this) {
				productCountsMap.put(i, productCountsMap.get(i).add(one));
				}
			}else {
				productCountsMap.put(i, one);
			}
		});
		
		
		//check inventory
		Boolean inventoryFlag = productInventory.checkInventory(productCountsMap.keySet());
		
		if(inventoryFlag) {
			List<PriceModel> priceList = productPrice.fetchProductPrice(productCountsMap.keySet());
			List<DiscountModel> discountList = productDiscount.fetchProductDiscount(productCountsMap.keySet());
			List<BigInteger> productsSumList = Collections.synchronizedList(new ArrayList<>());
			productCountsMap.entrySet().parallelStream().forEach(entry -> {
				//check if product has discount
				Optional<DiscountModel> discountModel = discountList.parallelStream().filter(discount -> 
					discount.getProductId() == entry.getKey()
				).findFirst();
				
				Optional<PriceModel> priceModel = priceList.parallelStream().filter(price -> 
				price.getProductId() == entry.getKey()).findFirst();
				//calculate checkout money amount
				if(priceModel.isPresent() && discountModel.isPresent()) {
					Integer price = priceModel.get().getPrice();
					Integer discountAmountUnit = discountModel.get().getDiscountAmoutUnit();
					Integer discountUnitPrice = discountModel.get().getDicountUnitPrice();
					//if product amount did not reach the discount level use original price
					BigInteger bigProductDiscountUnit = BigInteger.valueOf(discountAmountUnit);
					if(entry.getValue().compareTo(bigProductDiscountUnit) == -1) {
					  BigInteger sum = entry.getValue().multiply(BigInteger.valueOf(price));
					  productsSumList.add(sum);
					}else if(entry.getValue().compareTo(bigProductDiscountUnit) > -1) {
						BigInteger[] result = entry.getValue().divideAndRemainder(bigProductDiscountUnit);
						BigInteger sum = result[0].multiply(BigInteger.valueOf(discountUnitPrice)).add(result[1].multiply(BigInteger.valueOf(price)));
						productsSumList.add(sum);
					}
				}else if(priceModel.isPresent()){
					Integer price = priceModel.get().getPrice();
					BigInteger sum = entry.getValue().multiply(BigInteger.valueOf(price));
					productsSumList.add(sum);
				}else {
					//here should throw an error that we do not have this product.
					//but I do not think it will happen if they select product from front page.
					productsSumList.add(new BigInteger("0"));
				}
			});
			
			
			for(BigInteger bi : productsSumList) {
				checkoutResult = checkoutResult.add(bi);
			}
			return checkoutResult;
			
		}else {
		 //should throw out exception to tell front end to remind our customer, normally it should check by another api
		 // to set down this order. here we return 0 since we suppose we always has enough product left for sale;
		return checkoutResult;
		
		}
	}

}
