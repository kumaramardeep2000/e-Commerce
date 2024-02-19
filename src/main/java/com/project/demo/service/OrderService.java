package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Login;
import com.project.demo.model.Order;

public interface OrderService {
	void palceOrder(Order order);
	List<Order> orderByUser(Login login);
//	Order getOrderById(Integer order_id);
	
}
