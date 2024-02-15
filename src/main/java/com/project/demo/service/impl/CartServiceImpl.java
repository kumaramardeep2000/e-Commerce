package com.project.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Cart;
import com.project.demo.model.Login;
import com.project.demo.model.Product;
import com.project.demo.repository.CartRepository;
import com.project.demo.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cr;

	@Override
	public void addToCart(Cart cart) {
		cr.save(cart);
		
	}

	@Override
	public List<Cart> getCartByUser(Login login) {
		
		return cr.findByLogin(login);
	}

	@Override
	public void deleteCart(Login login, Product product) {
		cr.deleteByLoginAndProduct(login, product);
		
	}

	@Override
	public Cart getCartById(Integer cart_id) {
		// TODO Auto-generated method stub
		return cr.getById(cart_id);
	}

}
