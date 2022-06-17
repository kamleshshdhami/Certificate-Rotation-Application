package com.certificate.rotation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NonUniqueResultException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NonUniqueResultException(String message) {
		super(message);
	}


}
