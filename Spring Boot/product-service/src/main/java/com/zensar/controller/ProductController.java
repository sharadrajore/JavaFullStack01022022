package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.rest.template.CouponClient;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	

	@Autowired
	private ProductService productService;

	@Autowired
	private CouponClient couponClient;

	// @Autowired
	// private RestTemplate restTemplate;

	// http://localhost:8080/products
	@PostMapping("/")
	public Product insertProduct(@RequestBody Product product) {

		// ResponseEntity<Coupon> responseCoupon =
		// restTemplate.getForEntity("http://localhost:8082/coupons/"+product.getCouponCode(),Coupon.class);

		// ResponseEntity<Coupon> responseCoupon =
		// restTemplate.getForEntity("http://COUPON-SERVICE/coupons/"+product.getCouponCode(),Coupon.class);

		Coupon coupon = couponClient.getCoupon(product.getCouponCode());

		// Coupon coupon=responseCoupon.getBody();

		product.setPrice(product.getPrice() - coupon.getDiscount());

		return productService.insertProduct(product);
	}

}
