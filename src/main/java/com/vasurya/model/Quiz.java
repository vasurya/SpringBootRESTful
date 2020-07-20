package com.vasurya.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Quiz {
	@JsonIgnore
	@Id
	private int id;
	@NotBlank(message = "title is mandatory")
	private String title;
	@NotBlank(message = "text is mandatory")
	private String text;
	@Size(min=2)
	private String[] options;

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	@JsonIgnore
	private int[] answer;
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

	@JsonIgnore
	public int[] getAnswer() {
		return answer;
	}
	@JsonProperty
	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", text=" + text + ", options=" + Arrays.toString(options)
				+ ", answer=" + Arrays.toString(answer) + "]";
	}
	
	
}
