package com.project.demo.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_cart")
public class Cart {
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer cart_id;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="login_id")
	private Login login;
	
	@Column(name="product_quantity"	)
	private Integer product_quantity;

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product=" + product + ", login=" + login + ", product_quantity="
				+ product_quantity + "]";
	}

	
}
