package com.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Availability {
	private String title;
	private int dayIndex;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDayIndex() {
		return dayIndex;
	}
	public void setDayIndex(int dayIndex) {
		this.dayIndex = dayIndex;
	}
	
	

}
