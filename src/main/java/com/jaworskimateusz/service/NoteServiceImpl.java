package com.jaworskimateusz.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaworskimateusz.dao.NoteDao;
import com.jaworskimateusz.dao.UserDao;
import com.jaworskimateusz.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired 
	private NoteDao noteDao;
	
	@Autowired 
	private UserDao userDao;
	
	@Override
	@Transactional
	public void saveNote(Note note, HttpServletRequest request) {
		note.setUser(userDao.findByName(request.getRemoteUser()));
		note.setModificationDate(getCuttentDate());
		noteDao.saveNote(note);
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

	@Override
	@Transactional
	public List<Note> searchNotes(String searchingTitle) {
		return noteDao.searchNotes(searchingTitle);
	}

}
