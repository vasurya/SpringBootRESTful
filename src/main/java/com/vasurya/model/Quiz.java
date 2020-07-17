package com.vasurya.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Quiz {
	@JsonIgnore
	private int id;
	private String title;
	private String text;
	private String[] options;
	@JsonIgnore
	private int answer;
	@JsonProperty
	public int getId() {
		return id;
	}
	@JsonIgnore
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	@JsonIgnore
	public int getAnswer() {
		return answer;
	}
	@JsonProperty
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", text=" + text + ", options=" + Arrays.toString(options)
				+ ", answer=" + answer + "]";
	}
	
	
}
