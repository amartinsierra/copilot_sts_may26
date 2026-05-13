package com.caixaba.absis.microlibros.exception;

public class LibroExistsException extends RuntimeException {
    public LibroExistsException(String message) {
        super(message);
    }
}
