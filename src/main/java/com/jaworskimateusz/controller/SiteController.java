package com.jaworskimateusz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "index"; 
	}
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
}
