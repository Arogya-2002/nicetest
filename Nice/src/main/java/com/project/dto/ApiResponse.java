package com.project.dto;

import java.util.Date;

public class ApiResponse<T>{
    private Date timestamp;
    private String message;
    private int statuscode;
    private T data;
    

    // Constructor for error response (status is not null, data is null)
    public ApiResponse(int status, String message) {
        this.timestamp = new Date();
        this.statuscode = status;
        this.message = message;
     //   this.data = null;
    }
    public ApiResponse(int status, String message, T data) {
        this.timestamp = new Date();
        this.statuscode = status;
        this.message = message;
        this.data = data;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
}