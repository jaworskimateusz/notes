package com.jaworskimateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaworskimateusz.dao.NoteDao;
import com.jaworskimateusz.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired 
	private NoteDao noteDao;
	
	@Override
	@Transactional
	public void saveNote(Note note) {
		noteDao.saveNote(note);
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
