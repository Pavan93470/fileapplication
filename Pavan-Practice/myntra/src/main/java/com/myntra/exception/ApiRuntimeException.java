package com.myntra.exception;

import org.springframework.http.HttpStatus;


public class ApiRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private String exceptionName;
	private HttpStatus httpStatus;

	public ApiRuntimeException(String message, String exceptionName, HttpStatus httpStatus) {
		this.msg = message;
		this.exceptionName = exceptionName;
		this.httpStatus = httpStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
