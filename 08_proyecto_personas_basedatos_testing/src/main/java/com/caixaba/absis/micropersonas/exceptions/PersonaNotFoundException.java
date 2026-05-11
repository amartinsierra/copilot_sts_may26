package com.caixaba.absis.micropersonas.exceptions;

public class PersonaNotFoundException extends RuntimeException {
	public PersonaNotFoundException(Integer id) {
		super("Persona con id " + id + " no encontrada");
	}
}
