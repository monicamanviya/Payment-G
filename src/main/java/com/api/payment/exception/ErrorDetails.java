package com.api.payment.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	String errorCode;
	String errorMsg;
	int status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;
	

	public ErrorDetails() {
		
	}

	public ErrorDetails(String errorCode, String errorMsg, LocalDateTime timestamp) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.timestamp = timestamp;
	}



	public ErrorDetails(String errorCode, String errorMsg, int status, LocalDateTime timestamp) {
	
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.status = status;
		this.timestamp = timestamp;
	}



	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "ErrorDetails [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", status=" + status + ", timestamp="
				+ timestamp + "]";
	}
	
	
}
