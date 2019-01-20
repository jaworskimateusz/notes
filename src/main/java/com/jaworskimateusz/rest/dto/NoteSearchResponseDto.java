package com.jaworskimateusz.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteSearchResponseDto {
	
	private String title;
	
	private String content;
	
	private String modificationDate;
	
	private String priority;

	public NoteSearchResponseDto() {
	}

	public NoteSearchResponseDto(String title, String content, String modificationDate, String priority) {
		this.title = title;
		this.content = content;
		this.modificationDate = modificationDate;
		this.priority = priority;
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

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NoteSearchResponseDto [title=" + title + ", content=" + content + ", modificationDate="
				+ modificationDate + ", priority=" + priority + "]";
	}

}
