package com.project.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Order;
import com.project.demo.repository.orderRepository;
import com.project.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private orderRepository or;
	@Override
	public void palceOrder(Order order) {
		
		or.save(order);
	}

}
