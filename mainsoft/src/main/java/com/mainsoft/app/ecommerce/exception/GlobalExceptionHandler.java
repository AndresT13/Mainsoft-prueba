package com.mainsoft.app.ecommerce.exception;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exc,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> detalles = new ArrayList<String>();
		detalles = exc.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getObjectName() + " : " + err.getDefaultMessage()).collect(Collectors.toList());

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Errores de validación ", detalles, "428",LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método generado cuando un argumento de método de controlador con notación
	// @valid falla en la validación
	
	// Este método se genera cuando el cuerpo de la solicitud no es válido.
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exc,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add(exc.getMessage());

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Solicitud JSON con formato incorrecto", detalles, "424",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// Creación de clase de utilidad para ayudarnos a construir objetos
	// ResponseEntity a partir de objetos AppiError
//	protected static ResponseEntity<Object> build(ApiError apiError) {
//		return new ResponseEntity<>(apiError, apiError);
	//}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exc) {

		List<String> detalles = new ArrayList<String>();
		detalles.add(exc.getMessage());

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Recurso no encontrado", detalles, "404",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método de excepción que informa cuando un parámetro tiene el tipo incorrecto.
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exc,
			WebRequest request) {
		List<String> detalles = new ArrayList<String>();

		detalles.add(exc.getMessage());

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Falta de coincidencia de tipo", detalles, "415",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método de excepción que informa el resultado de violaciones de restricciones!
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(Exception exc, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add(exc.getMessage());
		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Violaciones de restricciones", detalles, "403",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método de excepción cuando un método de controlador no recibe parámetro
	// requerido
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException exc,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> detalles = new ArrayList<String>();
		detalles.add(exc.getParameterName() + " falta el parámetro");

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "\r\n" + "Error Parámetros faltantes", detalles, "409",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método de excepción que informa cuando el tipo de medio de solicitud
	// especificado "tipo de contenido" no es compatible.
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported
			(HttpMediaTypeNotSupportedException exc,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {

		List<String> detalles = new ArrayList<String>();
		
		
		StringBuilder builder = new StringBuilder();
		builder.append(exc.getContentType());
		builder.append("El tipo de medio no es compatible. Los tipos de medios admitidos son");
		exc.getSupportedMediaTypes().forEach(t -> builder.append(t).append(" ,"));

		detalles.add(builder.toString());

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "\r\n" + "Error Parámetros faltantes", detalles, "415",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);

	}

	// método de excepción para manejar el NoHandlerFoundException como cualquier otra excepción
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exc, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add(String.format("No se pudo encontrar el %s método por URL %s", exc.getHttpMethod(), exc.getRequestURL()));

		ApiError err = new ApiError(HttpStatus.NOT_FOUND, "Método no encontrado", detalles, "404",
				LocalDateTime.now());

		return ResponseEntityBuilder.build(err);
	}
	
	
	// método para manejar todas las demás excepciones
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(
			Exception exc,
			WebRequest request) {
		List<String> detalles = new ArrayList<String>();
		detalles.add(exc.getLocalizedMessage());
		
		ApiError  err = new ApiError (HttpStatus.NOT_FOUND,
				"Se produjo un error!...",
				detalles,
				"400",
				LocalDateTime.now());
		
		
		return ResponseEntityBuilder.build(err);

	}

}

