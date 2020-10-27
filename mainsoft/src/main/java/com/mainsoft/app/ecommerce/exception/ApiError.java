package com.mainsoft.app.ecommerce.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus httpStatus;

	private String messagge;

	private List<String> code;

	private String backEndMessage;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime createAt;

	public ApiError(HttpStatus httpStatus, String messagge, List<String> code, String backEndMessage,
			LocalDateTime createAt) {
		super();
		this.httpStatus = httpStatus;
		this.messagge = messagge;
		this.code = code;
		this.backEndMessage = backEndMessage;
		this.createAt = createAt;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}

	public List<String> getCode() {
		return code;
	}

	public void setCode(List<String> code) {
		this.code = code;
	}

	public String getBackEndMessage() {
		return backEndMessage;
	}

	public void setBackEndMessage(String backEndMessage) {
		this.backEndMessage = backEndMessage;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

}
