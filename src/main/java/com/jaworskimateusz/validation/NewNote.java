package com.jaworskimateusz.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewNote {

	@NotNull
	@Size(min = 1, message = "Required.")
	@Size(max = 255, message= "Maximum title length is 255.")
	private String title;
	
	@NotNull
	@Size(min = 1 , message = "Required.")
	@Size(max = 65534, message = "This note is to long.")
	private String content;
	
	private String priority;
	
	public  NewNote() {
		
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
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NewNote [title=" + title + ", content=" + content + ", priority=" + priority + "]";
	}
	
}
