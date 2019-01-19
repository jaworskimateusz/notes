package com.jaworskimateusz.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteSearchRequestDto {
	
	private String title;

	public NoteSearchRequestDto() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
