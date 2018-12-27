package com.jaworskimateusz.service;

import com.jaworskimateusz.entity.Note;

public interface NoteService {
	
	public void saveNote(Note note);
	
	public Note getNote(int noteId);
	
	public void deleteNote(int noteId);
	
}
