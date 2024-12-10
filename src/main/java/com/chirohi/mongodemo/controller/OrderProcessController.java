package com.chirohi.mongodemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirohi.mongodemo.model.Order;
import com.chirohi.mongodemo.service.OrderProcessServiceInterface;


@RestController
public class OrderProcessController {
	
	Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private  OrderProcessServiceInterface orderProcessService;
	
	@PostMapping("/create-order")
	public ResponseEntity<Object> createOrder(@RequestBody Order order){
		order = orderProcessService.createOrder(order);
		logger.info("created single order successfully!!!");
		return ResponseEntity.ok(order);
		
	}
	
	@PostMapping("/create-bulkOrder")
	public ResponseEntity<Object> createBulkOrder(@RequestBody List<Order> orderList){
		List<Order> orders = orderProcessService.createBulkOrder(orderList);
		logger.info("created bulk order successfully!!!");
		return ResponseEntity.ok(orders);
		
	}
	
	
}
