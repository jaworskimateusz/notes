package com.jaworskimateusz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaworskimateusz.entity.Note;
import com.jaworskimateusz.entity.User;

@SuppressWarnings("deprecation")
@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveNote(Note note) {
		sessionFactory.getCurrentSession().merge(note); 
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

	@Override
	public List<Note> searchNotes(String searchingTitle) {
		Session session  = sessionFactory.getCurrentSession();
		if(searchingTitle != null && isEmpty(searchingTitle)) {
			Query<Note> query = session.createQuery("FROM Note WHERE lower(title) like :searchingTitle");
			query.setParameter("searchingTitle", "%" + searchingTitle.toLowerCase() + "%");
			return query.getResultList();
		} else {
			return null;
		}
	}
	
	private boolean isEmpty(String searchingTitle) {
		return searchingTitle.trim().length() > 0 ? true : false;
	}

}
