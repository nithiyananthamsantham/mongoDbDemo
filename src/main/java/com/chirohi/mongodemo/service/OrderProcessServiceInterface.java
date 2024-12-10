package com.chirohi.mongodemo.service;

import java.util.List;

import com.chirohi.mongodemo.model.Order;

public interface OrderProcessServiceInterface {
	
	public Order createOrder(Order order);
	
	public List<Order> createBulkOrder(List<Order> orderList);

}
