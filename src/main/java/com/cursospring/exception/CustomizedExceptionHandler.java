package com.cursospring.exception;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex,
		WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ExceptionError error = new ExceptionError();
		error.setDataHora(OffsetDateTime.now());
		error.setStatus(status.value());
		error.setTitulo(ex.getMessage());
	
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
		WebRequest request){
		
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		
		ExceptionError error = new ExceptionError();
		error.setDataHora(OffsetDateTime.now());
		error.setStatus(status.value());
		error.setTitulo(ex.getMessage());
	
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}

}
