package com.capgemini.microalumnos.exceptions;

public class AlumnoAlreadyExistsException extends RuntimeException {
	private String dni;
	private String curso;
	public AlumnoAlreadyExistsException(String dni, String curso) {
		super(String.format("El alumno con dni %s ya existe en el curso %s", dni, curso));
		this.dni = dni;
		this.curso = curso;
	}
	public String getDni() {
		return dni;
	}
	public String getCurso() {
		return curso;
	}
}
