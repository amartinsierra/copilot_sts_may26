package com.capgemini.micropersonas.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException;
import com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException;
@RestControllerAdvice
public class PersonasExceptionsController {
	@ExceptionHandler(PersonaNotFoundException.class)
	public ResponseEntity<String> handlePersonaNotFoundException(PersonaNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(PersonaAlreadyExistsException.class)
	public ResponseEntity<String> handlePersonaAlreadyExistsException(PersonaAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
}
