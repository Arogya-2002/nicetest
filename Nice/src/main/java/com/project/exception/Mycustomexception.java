package com.project.exception;

import org.springframework.http.HttpStatus;

public class Mycustomexception extends RuntimeException {
	private final HttpStatus status;
		public Mycustomexception(String message,HttpStatus status) {
		super(message);
		this.status = status;
		
		}
		public HttpStatus getStatus() {
			return status;
		}		
		}


