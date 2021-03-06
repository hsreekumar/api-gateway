package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domain.Order;
import com.ecommerce.services.GatewayClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@RequestMapping("/api")
@Api(value = "Order Api")
public class OrderController {

	@Autowired
	GatewayClient orderService;


	/**
	 * Create batch order
	 * 
	 * @param Order
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "Create Batch order")
	@PostMapping("/batch")
	public void createBatchOrder(@RequestBody Order order) throws Exception {
		orderService.createBatchOrder(order);
	}
	
	/**
	 * Return Order Details by Id
	 * 
	 * @param OrderId
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "Get order", response = Order.class)
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable("orderId") Long orderId) throws Exception {
		return orderService.getOrder(orderId);
	}
	
	/**
	 * Create order
	 * 
	 * @param order
	 * @return Order
	 * @throws Exception 
	 */
	@ApiOperation(value = "Create order", response = Order.class)
	@PostMapping
	public Order createOrder(@RequestBody Order order) throws Exception {
		return orderService.createOrder(order);
	}
	
	/**
	 * Cancel order
	 * @param order
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "Cancel order", response = Order.class)
	@PutMapping("/cancel")
	public Order cancelOrder(@RequestBody Order order) throws Exception {
		return orderService.cancelOrder(order);
	}
	
	/**
	 * 
	 * @param orders
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "Create bulk orders", response = Boolean.class)
	@PostMapping("/bulk")
	public boolean addBulkOrder(@RequestBody List<Order> orders) throws Exception {
		boolean ack = false;
		ack = orderService.createBulkOrder(orders);
		return ack;
	}
	
}