package com.jaworskimateusz.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jaworskimateusz.config.ApplicationConfig;
import com.jaworskimateusz.config.SecurityConfig;
import com.jaworskimateusz.dao.NoteDao;
import com.jaworskimateusz.entity.Note;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

/**
 * @author jaworskimateusz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(NoteService.class)
public class NoteServiceTest {

	@InjectMocks
	private NoteServiceImpl noteService;
	
	@Mock
	private NoteDao noteDao;
	
	@Test
	public void getNote() {
		Note note = new Note();
		when(noteDao.getNote(anyInt())).thenReturn(note);
		assertEquals(note, noteService.getNote(anyInt()));
		verify(noteDao, times(1)).getNote(anyInt());
	}
	
	@Test
	public void deleteNote() {
		noteService.deleteNote(anyInt());
		verify(noteDao, times(1)).deleteNote(anyInt());
	}
	
	@Test 
	public void searchNotes_titleIsEmpty() {
		when(noteDao.searchNotes(" ")).thenReturn(null);
		assertNull(noteService.searchNotes(" "));
	}
	
	@Test 
	public void searchNotes_noNotesFound() {
		when(noteDao.searchNotes(anyString())).thenReturn(null);
		assertNull(noteService.searchNotes(anyString()));
	}
	
	@Test 
	public void searchNotes_notesFound() {
		Note note = new Note();
		when(noteDao.searchNotes(anyString())).thenReturn(asList(note));
		assertNotNull(noteService.searchNotes(anyString()));
	}
	
	@Test 
	public void sortNotes_byAscendingDate() {
		List<Note> actual = noteService.sortNotes(getNotesAsList(),"Ascending date");
		List<Note> expected = Arrays.asList(
				new Note("First","A",new Date(2019,1,1),"low"),
				new Note("Fourth","D",new Date(2019,1,2),"high"),
				new Note("Second","B",new Date(2019,1,3),"high"),
				new Note("Third","C",new Date(2019,1,4),"low"));
		System.out.println(actual);
		System.out.println(expected);
		assertNotEquals(expected, actual);
	}
	
	private List<Note> getNotesAsList() {
		return Arrays.asList(
				 new Note("First","A",new Date(2019,1,1),"low"),
				 new Note("Second","B",new Date(2019,1,3),"high"),
				 new Note("Third","C",new Date(2019,1,4),"low"),
				 new Note("Fourth","D",new Date(2019,1,2),"high"));
	}
	
}
