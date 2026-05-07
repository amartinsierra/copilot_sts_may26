package com.caixaba.absis.microalumnos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class AlumnoEntity {
	//crea una entidad con los campos idAlumno, dni, nombre, curso y nota, el campo idAlumno es la clave primaria autoincremental
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long idAlumno;
	
	@jakarta.persistence.Column(name = "dni", nullable = false, unique = true)
	private String dni;
	
	@jakarta.persistence.Column(name = "nombre", nullable = false)
	private String nombre;
	
	@jakarta.persistence.Column(name = "curso", nullable = false)
	private String curso;
	
	@jakarta.persistence.Column(name = "nota")
	private Double nota;
	//constructores, getters y setters
	public AlumnoEntity() {
	}
	public AlumnoEntity(String dni, String nombre, String curso, Double nota) {
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}
	public Long getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
}
