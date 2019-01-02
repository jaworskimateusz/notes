package com.jaworskimateusz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaworskimateusz.entity.User;
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
		User user = userService.findByName(request.getRemoteUser());
		session.setAttribute("user", user);
		return user == null ? "login" : "home";
	}
	
	@GetMapping("/access-denied")
	public String showAccesDeniedPage() {
		return "access-denied";
	}
	
}
