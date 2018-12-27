package com.jaworskimateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.service.NoteService;

@Controller
@RequestMapping("/home")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/add-note")
	public String showFormForAdd(Model model) {
		model.addAttribute("note", new Note());
		return "add-form";
	}
	
	@PostMapping("/save-note")
	public String saveNote(@ModelAttribute("note") Note note) {
		noteService.saveNote(note);
		return "redirect:/home";
	}
	
	@GetMapping("/delete-note")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		noteService.deleteNote(noteId);
		return "redirect:/home";
	}

}
