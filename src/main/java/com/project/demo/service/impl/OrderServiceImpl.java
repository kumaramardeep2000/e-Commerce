package com.project.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Login;
import com.project.demo.model.Order;
import com.project.demo.repository.OrderRepository;
import com.project.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository or;
	@Override
	public void palceOrder(Order order) {
		
		or.save(order);
	}
	@Override
	public List<Order> orderByUser(Login login) {
		
		return or.findOrderByUser(login);
	}
//	@Override
//	public Order getOrderById(Integer order_id) {
//		// TODO Auto-generated method stub
//		return or.getById(order_id);
//	}

}
