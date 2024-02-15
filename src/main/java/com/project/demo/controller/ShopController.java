package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.demo.service.ProductService;

@Controller
public class ShopController {

	@Autowired
	ProductService ps;
	
	@GetMapping("/shop")
	public String shopping(Model model ) {
		model.addAttribute("products", ps.getAllProduct());
		return "shop";
	}
}
