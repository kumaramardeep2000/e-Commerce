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

	@Override
	public void incrementQuantity(Cart cart) {
		cart.setProduct_quantity(cart.getProduct_quantity()+1);
		cr.save(cart);
		
	}

	@Override
	public void decrementQuantity(Cart cart) {
		cart.setProduct_quantity(cart.getProduct_quantity()-1);
		cr.save(cart);		
	}

	@Override
	public Double grandTotal(List<Cart> cart) {
		Double grandTotal=0.0;
		for(Cart item:cart) {
			Double total =item.getProduct_quantity() * item.getProduct().getProduct_price();
			grandTotal+=total;
			}
		return grandTotal;
	}

}
