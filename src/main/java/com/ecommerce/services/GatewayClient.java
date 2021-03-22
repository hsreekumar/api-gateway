package com.ecommerce.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.domain.Order;

@FeignClient(name = "eureka-zuul-service")
public interface GatewayClient {
	
	@RequestMapping(method=RequestMethod.POST, value="/orders/order")
	public Order createOrder(@RequestBody Order order);
	
	@RequestMapping(method=RequestMethod.GET, value="/orders/order/{orderId}")
	public Order getOrder(@PathVariable("orderId") Long orderId);
	
	@RequestMapping(method=RequestMethod.PUT, value="/orders/order/cancel")
	public Order cancelOrder(@RequestBody Order order);
	
	@RequestMapping(method=RequestMethod.POST, value="/orders/order/bulk")
	public boolean createBulkOrder(@RequestBody List<Order> orders);
	
	@RequestMapping(method=RequestMethod.POST, value="/batches/batch/order")
	public void createBatchOrder(@RequestBody Order order);
	
}