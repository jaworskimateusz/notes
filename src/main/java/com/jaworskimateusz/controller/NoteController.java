package com.jaworskimateusz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaworskimateusz.service.NoteService;
import com.jaworskimateusz.validation.NewNote;

@Controller
@RequestMapping("/home")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/add-note")
	public String showFormForAdd(Model model) {
		model.addAttribute("note", new NewNote());
		return "update-note";
	}
	
	@PostMapping("/save-note")
	public String saveNote(@Valid @ModelAttribute("note") NewNote note, 
			BindingResult bindingResult,
			Model model,
			HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			return "update-note";
		}
		noteService.saveNote(note, request);
		return "redirect:/home";
	}
	
	@GetMapping("/delete-note")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		noteService.deleteNote(noteId);
		return "redirect:/home";
	}

}