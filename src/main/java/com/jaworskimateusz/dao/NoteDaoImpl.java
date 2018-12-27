package com.jaworskimateusz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaworskimateusz.entity.Note;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
	}

	@Override
	public Note getNote(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Note.class, noteId);
	}

	@Override
	public void deleteNote(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Note.class, noteId));
	}

}
