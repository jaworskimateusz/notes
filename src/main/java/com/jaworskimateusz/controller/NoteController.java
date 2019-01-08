package com.jaworskimateusz.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.entity.User;
import com.jaworskimateusz.service.NoteService;
import com.jaworskimateusz.service.UserService;

@Controller
@RequestMapping("/home")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add-note")
	public String showFormForAdd(Model model) {
		model.addAttribute("note", new Note());
		return "update-note";
	}
	
	@GetMapping("/update-note")
	public String updateNote(@RequestParam("noteId") int noteId, Model model) {
		model.addAttribute("note", noteService.getNote(noteId));
		return "update-note";
	}
	
	@PostMapping("/save-note")
	public String saveNote(@Valid @ModelAttribute("note") Note note, 
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
	
	@PostMapping("/search-notes") 
	public String searchNote(@RequestParam("searchInput") String searchingTitle, 
			HttpServletRequest request,
			HttpSession session) {
		List<Note> notes = noteService.searchNotes(searchingTitle);
		User user = userService.findByName(request.getRemoteUser());
		user.setNotes(notes);
		session.setAttribute("user", user);
		return "home";
	}
	
	@PostMapping("/order-notes")
	public String orderNotes(@RequestParam String sequence, 
			HttpServletRequest request,
			HttpSession session) {
		User user = userService.findByName(request.getRemoteUser());
		user.setNotes(sortNotes(user.getNotes(), sequence));
		session.setAttribute("user", user);
		return "home";
	}

	private List<Note> sortNotes(List<Note> unorderedNotes, String sequence) {
		if (sequence.split(" ")[1] == "priority") {
			return sequence.startsWith("Ascending") 
					? unorderedNotes.stream().sorted(Comparator.comparing(Note::getPriority)).collect(Collectors.toList())
					: unorderedNotes.stream().sorted(Comparator.comparing(Note::getPriority).reversed()).collect(Collectors.toList());
		} else {
			return sequence.startsWith("Ascending")
				? unorderedNotes.stream().sorted(Comparator.comparing(Note::getModificationDate)).collect(Collectors.toList())
				: unorderedNotes.stream().sorted(Comparator.comparing(Note::getModificationDate).reversed()).collect(Collectors.toList());
		}
	}

}
