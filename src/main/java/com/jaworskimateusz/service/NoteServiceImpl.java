package com.jaworskimateusz.service;

import java.sql.Timestamp;

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
		System.out.println(note.getModificationDate());
		noteDao.saveNote(note);
	}

	private void setNoteProperties(Note note, NewNote newNote) {
		note.setTitle(newNote.getTitle());
		note.setContent(newNote.getContent());
		note.setPriority(newNote.getPriority());
		note.setModificationDate(getCuttentDate());
	}

	private Timestamp getCuttentDate() {
		return new Timestamp(System.currentTimeMillis());
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
