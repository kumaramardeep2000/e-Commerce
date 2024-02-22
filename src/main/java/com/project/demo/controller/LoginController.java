package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.demo.model.Login;
import com.project.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService ls;
	
	@GetMapping("/login")
	public String loginSection(Login login) {
		return "login";
		
	}
	@PostMapping("/login")
	public String loginSection(Model model, String email, String password, HttpSession session) {
		try {
//		model.addAttribute("login", ls.getByEmail(email));
		System.out.println(ls.getByEmail(email));
		Login user = ls.getByEmail(email);
		if(user!=null && password.equals(user.getPassword())) {
			session.setAttribute("loginData", user);
			return "redirect:/";
		}
		
		}catch (Exception e) {
			return "redirect:/login";
		}
		return "redirect:/login";
		
		
	}
	
	@GetMapping("/register")
	public String register() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String registration(Model model, Login login) {
		model.addAttribute("loginData", login);
//		System.out.println(ls.saveUser(login));
		ls.saveUser(login);
		return "redirect:/login";
	}
	
	@GetMapping("/userLogout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/userDashboard")
	public String dashboard(HttpSession session, Model model) {
		Login user= (Login) session.getAttribute("loginData");
		if(user!=null) {
			ls.getByEmail(user.getEmail());
			model.addAttribute("userData", user);
			return "/userDashboard";
		}
		else {
			return "redirect:/login";
		}
	}
	@PostMapping("/userUpdate")
	public String userUpdate(@RequestParam("email") String email, Model model) {
		Login user = ls.getByEmail(email);
		model.addAttribute("userData", user);
		return "userUpdate";
		
		
	}

}
