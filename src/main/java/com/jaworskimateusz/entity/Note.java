package com.jaworskimateusz.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="note_id")
	private int noteId;
	
	@NotNull
	@Size(min = 1, message = "Required.")
	@Size(max = 255, message= "Maximum title length is 255.")
	@Column(name="title")
	private String title;
	
	@NotNull
	@Size(min = 1 , message = "Required.")
	@Size(max = 65534, message = "This note is to long.")
	@Column(name="content")
	private String content;
	
	@Column(name="modification_date")
	private Date modificationDate;
	
	@Column(name="priority")
	private String priority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Note() {
	}
	
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", content=" + content + ", modificationDate=" + modificationDate
				+ ", priority=" + priority + ", user=" + user + "]";
	}

}
