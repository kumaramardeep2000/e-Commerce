package com.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

}
