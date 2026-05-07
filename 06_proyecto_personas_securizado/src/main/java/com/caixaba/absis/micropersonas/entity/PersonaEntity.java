package com.caixaba.absis.micropersonas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class PersonaEntity {
	@Id
	private Integer id;
	private String nombre;
	private Integer edad;
	private String email;

	public PersonaEntity() {
		super();
	}

	public PersonaEntity(Integer id, String nombre, Integer edad, String email) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
