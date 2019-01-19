package com.jaworskimateusz.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteSearchResponseDto {
	
	private String title;
	
	private String content;

	public NoteSearchResponseDto() {
	}

	public NoteSearchResponseDto(String title, String content) {
		this.title = title;
		this.content = content;
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
	
}
