package com.jaworskimateusz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String showHomePage() {
		return "about";
	}
	
	@GetMapping("/registration")
	public String showRegistrationPage() {
		return "registration";
	}
	
}
