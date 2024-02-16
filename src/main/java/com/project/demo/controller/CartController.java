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
import com.project.demo.model.Product;
import com.project.demo.service.CartService;
import com.project.demo.service.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class CartController {

	@Autowired
	private CartService cs;

	@Autowired
	private ProductService ps;

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
//session.getAttribute("loginData");"loginData is same name as where i set session means in loginController"
		Login user = (Login) session.getAttribute("loginData");
		if (user != null) {
			List<Cart> cartData = cs.getCartByUser(user);
			model.addAttribute("cart", cartData);
//				for (Cart cart : cartData) {
//					System.out.println(cart);
//				}
			return "cart";
		} else {
			return "redirect:/login";
		}

	}

	@PostMapping("/addToCart")
	public String addToCart(HttpSession session, @RequestParam("product_id") Integer product_id) {
		Login user = (Login) session.getAttribute("loginData");
		if (user != null) {
			Product product = ps.searchProductById(product_id);
			System.out.println(product);
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setLogin(user);
			cart.setProduct_quantity(1);
			List<Cart> cartData = cs.getCartByUser(user);
			if (!cartData.isEmpty()) {
				for (Cart oldCart : cartData) {

					if (product_id == oldCart.getProduct().getProduct_id()) {
						System.out.println("hello");
						cart.setProduct_quantity(oldCart.getProduct_quantity() + 1);
						cart.setCart_id(oldCart.getCart_id());

					}
				}

			}
			cs.addToCart(cart);
			return "redirect:/shop";
		} else {
			return "redirect:/login";
		}

	}

	@Transactional
	@PostMapping("/deleteCart")
	public String deleteCart(HttpSession session, @RequestParam("product_id") Integer product_id) {
		Login user = (Login) session.getAttribute("loginData");
		Product product = ps.searchProductById(product_id);
		cs.deleteCart(user, product);

		return "redirect:/cart";
	}

//	@PostMapping("/deleteCart/{product_id}")
//	public String deleteCart(HttpSession session, @PathVariable("product_id") Integer product_id) {
//		Login user = (Login) session.getAttribute("loginData");
//		Product product= ps.searchProductById(product_id);
//		cs.deleteCart(user, product);
//		return "redirect:/cart";
//	}

	@PostMapping("/updateQuantity")
	public String updateQuantity(@RequestParam("cart_id") Integer cart_id,
								 @RequestParam("quantityBtn") String quantityButton) {
		Cart cart = cs.getCartById(cart_id);
		if(quantityButton.equals("+")) {
			cs.incrementQuantity(cart);
		}
		else if(quantityButton.equals("-")) {
			cs.decrementQuantity(cart);
		}
		return "redirect:/cart";
		
		
	}

}
