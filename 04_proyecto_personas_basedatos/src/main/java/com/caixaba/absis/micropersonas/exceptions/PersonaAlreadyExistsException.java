package com.caixaba.absis.micropersonas.exceptions;

public class PersonaAlreadyExistsException extends RuntimeException {
	public PersonaAlreadyExistsException(Integer id) {
		super("Persona con id " + id + " ya existe");
	}
}
