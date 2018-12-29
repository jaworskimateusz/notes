package com.jaworskimateusz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaworskimateusz.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String showHomePage(HttpServletRequest request, HttpSession session) {
		session.setAttribute("user", userService.findByName(request.getRemoteUser()));
		return "home";
	}
	
	@GetMapping("/access-denied")
	public String showAccesDeniedPage() {
		return "access-denied";
	}
	
}
