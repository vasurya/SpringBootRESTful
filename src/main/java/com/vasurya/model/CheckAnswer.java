package com.vasurya.model;

import org.springframework.stereotype.Component;

@Component
public class CheckAnswer {
	private boolean success;
	private String feedback;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@Override
	public String toString() {
		return "CheckAnswer [success=" + success + ", feedback=" + feedback + "]";
	}
}
