package com.project.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Cart;
import com.project.demo.model.Login;
import com.project.demo.model.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByLogin(Login login);
	void deleteByLoginAndProduct(Login login,Product product);
}
