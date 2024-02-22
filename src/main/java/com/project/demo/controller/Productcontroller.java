package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.demo.model.Product;
import com.project.demo.service.ProductService;

@Controller
public class Productcontroller {

	@Autowired
	private ProductService ps;

	@GetMapping("/viewProduct")
	public String viewAllProduct(Model model) {
		model.addAttribute("products", ps.getAllProduct());
		return "admin/viewProduct";

	}

	@GetMapping("/addProduct")
	public String addProduct() {

		return "admin/addProduct";
	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("productData") Product product) {
		try {
			ps.saveProduct(product);
			return "redirect:/viewProduct?success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/login?error";
		}

	}

	@GetMapping("/delete/{product_id}")
	public String deleteProduct(@PathVariable("product_id") Integer product_id) {
		ps.deleteProductById(product_id);
		return "redirect:/viewProduct";
	}

	@GetMapping("/update/{product_id}")
	public String updateProduct(Model model, @PathVariable("product_id") Integer product_id) {
		Product product = ps.searchProductById(product_id);
		model.addAttribute("product", product);
		return "admin/updateProduct";

	}
	@GetMapping("/singleProduct/{product_id}")
	public String singleProduct(@PathVariable("product_id") Integer product_id, Model model) {
		Product productById = ps.searchProductById(product_id);
		model.addAttribute("product", productById);
		return "singleProduct";
		
	}
}
