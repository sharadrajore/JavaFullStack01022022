package com.zensar.rest.template;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;

@FeignClient("gateway-service")
public interface CouponClient {
	
	@GetMapping("/coupons/{couponCode}")
	Coupon getCoupon(@PathVariable String couponCode);

}
