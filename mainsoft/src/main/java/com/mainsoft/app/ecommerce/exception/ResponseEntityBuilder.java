package com.mainsoft.app.ecommerce.exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

	public static ResponseEntity<Object> build( ApiError apiError) {
		return new ResponseEntity<Object>(apiError, apiError.getHttpStatus());
	}
}
