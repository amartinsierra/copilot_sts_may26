package com.capgemini.microlibros.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caixaba.absis.microlibros.exception.LibroExistsException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LibroExistsException.class)
    public ResponseEntity<String> handleLibroExistsException(LibroExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
