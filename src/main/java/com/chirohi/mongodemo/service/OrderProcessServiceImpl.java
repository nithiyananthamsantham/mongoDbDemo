package com.chirohi.mongodemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirohi.mongodemo.model.Order;
import com.chirohi.mongodemo.repository.OrderProcessRepository;

@Service
public class OrderProcessServiceImpl implements OrderProcessServiceInterface{

	@Autowired
	OrderProcessRepository orderProcessRepository;
	
	@Override
	public Order createOrder(Order order) {
		return orderProcessRepository.save(order);
	}

	@Override
	public List<Order> createBulkOrder(List<Order> orderList) {
		return orderProcessRepository.saveAll(orderList);
	}

}
