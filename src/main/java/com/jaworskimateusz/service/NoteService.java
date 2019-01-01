package com.jaworskimateusz.service;

import javax.servlet.http.HttpServletRequest;

import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.validation.NewNote;

public interface NoteService {
	
	public void saveNote(NewNote note, HttpServletRequest request);
	
	public Note getNote(int noteId);
	
	public void deleteNote(int noteId);
	
}
