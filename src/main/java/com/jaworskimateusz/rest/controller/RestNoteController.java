package com.jaworskimateusz.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.rest.dto.NoteSearchRequestDto;
import com.jaworskimateusz.rest.dto.NoteSearchResponseDto;
import com.jaworskimateusz.service.NoteService;

@RestController
@RequestMapping("/api")
public class RestNoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/searching")
	public List<NoteSearchResponseDto> searchNotesByTitle(@RequestBody NoteSearchRequestDto dto) {
		return mapToDto(noteService.searchNotes(dto.getTitle()));
	}
	
	@GetMapping("/searching/{id}")
	public NoteSearchResponseDto searchNoteById(@PathVariable int id) {
		return mapToDto(noteService.getNote(id));
	}
	
	private NoteSearchResponseDto mapToDto(Note note) {
		return note == null ? 
				new NoteSearchResponseDto() :
				new NoteSearchResponseDto(note.getTitle(), note.getContent(),note.getModificationDate().toString(), note.getPriority());
	}

	private List<NoteSearchResponseDto> mapToDto(List<Note> notes) {
		List<NoteSearchResponseDto> mappedNotes = new ArrayList<>();
		for(int i = 0; i < notes.size() ; i++) {
			mappedNotes.add(new NoteSearchResponseDto(notes.get(i).getTitle(), notes.get(i).getContent(),
					notes.get(i).getModificationDate().toString(), notes.get(i).getPriority()));
		}
		return mappedNotes;
	}

}
  