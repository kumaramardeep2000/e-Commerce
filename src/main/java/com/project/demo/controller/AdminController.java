package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.demo.model.Admin;
import com.project.demo.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService as;
	
	@GetMapping("/admin")
	public String adminLogin(Model model, Admin admin) {
		model.addAttribute("admin", new Admin());
		return "admin";
	}
	
	@PostMapping("/admin")
	public String loginAdmin( String email, String password, Model model) {
		Admin user=as.getByEmail(email);
		System.out.println(as.getByEmail(email));
		
		return "redirect:/admin";
	}

}
