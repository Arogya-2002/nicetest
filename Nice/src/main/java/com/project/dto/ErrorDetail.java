package com.project.dto;

import java.util.Date;

public class ErrorDetail {
    private Date timestamp;
    private String message;
    private int statuscode;
    
    public ErrorDetail(Date timestamp,String message,int statuscode)
    {
    	this.timestamp = timestamp;
    	this.message=message;
    	this.statuscode = statuscode;
    }

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
    
}