package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Cart;
import com.project.demo.model.Login;
import com.project.demo.model.Product;

public interface CartService {
	void addToCart(Cart cart);
	List<Cart> getCartByUser(Login login);
	void deleteCart(Login login,Product product);
	Cart getCartById(Integer cart_id);
}
