package com.jaworskimateusz.service;

import javax.servlet.http.HttpServletRequest;

import com.jaworskimateusz.entity.Note;

public interface NoteService {
	
	public void saveNote(Note note, HttpServletRequest request);
	
	public Note getNote(int noteId);
	
	public void deleteNote(int noteId);
	
}
