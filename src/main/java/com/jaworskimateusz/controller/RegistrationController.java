package com.jaworskimateusz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaworskimateusz.service.UserService;
import com.jaworskimateusz.validation.NewUser;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/registration")
	public String showRegistrationPage(Model model) {
		model.addAttribute("newUser", new NewUser());
		return "registration";
	}
	
	@PostMapping("/process-registration")
	public String processRegistration(@Valid @ModelAttribute("newUser") NewUser newUser,
			Model model,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		
		if(userService.findByEmail(newUser.getEmail()) != null) {
			model.addAttribute("newUser", new NewUser());
			model.addAttribute("registrationError", "User email is already exists.");
			return "registration";
		}
		
		userService.save(newUser);
		return "login";
	}
}
