package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.model.Cart;
import com.project.demo.model.Login;
import com.project.demo.model.Order;
import com.project.demo.model.Product;
import com.project.demo.service.CartService;
import com.project.demo.service.OrderService;
import com.project.demo.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/checkout")
	public String checkout(HttpSession session, Model model) {
		Login user= (Login) session.getAttribute("loginData");
		if(user!=null) {
			List<Cart> cartData = cartService.getCartByUser(user);
			System.out.println("cartData"+cartData);
			model.addAttribute("cart", cartData);
			
			for(Cart cart:cartData) {
				System.out.println(cart);
			}
			Double grandTotal = cartService.grandTotal(cartData);
			model.addAttribute("grandTotal", grandTotal);
			
			return "checkout";
		}else {
			return "redirect:/login";
		}
		
	}
	
	@PostMapping("/checkout")
	public String placeOrder(HttpSession session, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("Address") String address, 
			@RequestParam("Mobile") String mobile) {
		Login user= (Login) session.getAttribute("loginData");
		List<Cart> cartData = cartService.getCartByUser(user);
		for (Cart cart : cartData) {
			Order order =new Order();
			order.setProduct_name(cart.getProduct().getProduct_name());
			order.setProduct_category(cart.getProduct().getProduct_description());
			order.setProduct_price(cart.getProduct().getProduct_price());
			order.setProduct_img(cart.getProduct().getProduct_img());
			order.setProduct_quantity(cart.getProduct_quantity());
			order.setUser(user);
			order.setOrder_status("pending");
			order.setPayment_mode("cash");
			order.setOrder_user_name(name);
			order.setOrder_user_email(email);
			order.setOrder_user_phone(mobile);
			order.setOrder_address(address);
			os.palceOrder(order);	
		}
		//clear cart after place order
		for(Cart cart:cartData) {
			cartService.clearCart(cart);
		}
		//update product Stock After Order Placed
		for(Cart cart:cartData) {
			Product product = cart.getProduct();
			int order_quantity = cart.getProduct_quantity();
			int updatedStock= product.getProduct_quantity() - order_quantity;
			product.setProduct_quantity(updatedStock);
			productService.saveProduct(product); 
		}
				return "redirect:/orderConfirmPage";
		
	}
	
	@GetMapping("/orderConfirmPage")
	public String orderConfirmation() {
		return "orderConfirmPage";
	}
	
	@GetMapping("/userOrder")
	public String orderByUser(Model model, HttpSession session) {
		Login user= (Login) session.getAttribute("loginData");
		if(user!=null) {
			List<Order> orderByUser = os.orderByUser(user);
			model.addAttribute("orderData", orderByUser);
		}
		return "userOrderDetails";
		
	}
	
	@GetMapping("/userOrder/{Order_id}")
	public String singleOrder(@PathVariable("Order_id") Integer order_id,HttpSession session, Model model) {
		Login user= (Login) session.getAttribute("loginData");
		if(user!=null) {
			Order orderById = os.getOrderById(order_id);
			model.addAttribute("order", orderById);
			return "singleOrder";
			
		}else {
			return "redirect:/login";
		}
	}
}
