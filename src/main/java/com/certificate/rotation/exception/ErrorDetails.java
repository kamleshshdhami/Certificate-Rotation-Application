package com.certificate.rotation.exception;

import java.util.List;

public class ErrorDetails {

	private String message;
	private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public ErrorDetails(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

}
