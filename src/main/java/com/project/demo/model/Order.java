package com.project.demo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer Order_id;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="product_category")
	private String product_category;
	
	
	@Column(name = "product_price")
	private Double product_price;
	
	@Column(name = "product_image")
	private String product_img;
	
	@Column(name = "product_quantity")
	private Integer product_quantity;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	private Login user;
	
	@CreationTimestamp
	@Column(name = "order_date")
	private LocalDateTime order_date;
	
	@UpdateTimestamp
	@Column(name = "cancel_date")
	private LocalDateTime cancel_date;
	
	@Column(name = "order_status")
	private String order_status;
	
	@Column(name = "payment_mode")
	private String payment_mode;

	@Column(name="user_name")
	private String order_user_name;
	
	@Column(name = "user_email")
	private String order_user_email;
	
	@Column(name = "user_phone")
	private String order_user_phone;
	
	@Column(name = "order_address")
	private String order_address;

	public Integer getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(Integer order_id) {
		Order_id = order_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public LocalDateTime getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(LocalDateTime cancel_date) {
		this.cancel_date = cancel_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getOrder_user_name() {
		return order_user_name;
	}

	public void setOrder_user_name(String order_user_name) {
		this.order_user_name = order_user_name;
	}

	public String getOrder_user_email() {
		return order_user_email;
	}

	public void setOrder_user_email(String order_user_email) {
		this.order_user_email = order_user_email;
	}

	public String getOrder_user_phone() {
		return order_user_phone;
	}

	public void setOrder_user_phone(String order_user_phone) {
		this.order_user_phone = order_user_phone;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	
	@Override
	public String toString() {
		return "Order [Order_id=" + Order_id + ", product_name=" + product_name + ", product_category="
				+ product_category + ", product_price=" + product_price + ", product_img=" + product_img
				+ ", product_quantity=" + product_quantity + ", user=" + user + ", order_date=" + order_date
				+ ", cancel_date=" + cancel_date + ", order_status=" + order_status + ", payment_mode=" + payment_mode
				+ ", order_user_name=" + order_user_name + ", order_user_email=" + order_user_email
				+ ", order_user_phone=" + order_user_phone + ", order_address=" + order_address + "]";
	}
}
