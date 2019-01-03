package com.jaworskimateusz.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaworskimateusz.dao.NoteDao;
import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.validation.NewNote;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired 
	private NoteDao noteDao;
	
	@Autowired 
	private UserService userService;
	
	@Override
	@Transactional
	public void saveNote(NewNote newNote, HttpServletRequest request) {
		Note note = new Note();
		setNoteProperties(note, newNote);
		note.setUser(userService.findByName(request.getRemoteUser()));
		noteDao.saveNote(note);
	}

	private void setNoteProperties(Note note, NewNote newNote) {
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());
		note.setPriority(checkPriority(newNote));
		note.setModificationDate(getCuttentDate());
	}
	
	private String checkPriority(NewNote newNote) {
		return newNote.getPriority() != null ? "high" : null;
	}

	private Date getCuttentDate() {
		return new Date(System.currentTimeMillis());
	}

	@Override
	@Transactional
	public Note getNote(int noteId) {
		return noteDao.getNote(noteId);
	}

	@Override
	@Transactional
	public void deleteNote(int noteId) {
		noteDao.deleteNote(noteId);
	}

}
