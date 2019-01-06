package com.jaworskimateusz.dao;

import java.util.List;

import com.jaworskimateusz.entity.Note;

public interface NoteDao {

	public void saveNote(Note note);
	
	public Note getNote(int noteId);
	
	public void deleteNote(int noteId);

	public List<Note> searchNotes(String searchingTitle);
}
