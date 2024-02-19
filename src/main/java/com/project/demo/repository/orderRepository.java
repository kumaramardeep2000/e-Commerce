package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Login;
import com.project.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findOrderByUser(Login login);

}
