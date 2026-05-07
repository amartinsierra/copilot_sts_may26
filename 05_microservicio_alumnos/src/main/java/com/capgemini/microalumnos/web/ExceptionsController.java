package com.capgemini.microalumnos.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.microalumnos.exceptions.AlumnoAlreadyExistsException;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(AlumnoAlreadyExistsException.class)
	public ResponseEntity<String> handleAlumnoAlreadyExistsException(AlumnoAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
}
