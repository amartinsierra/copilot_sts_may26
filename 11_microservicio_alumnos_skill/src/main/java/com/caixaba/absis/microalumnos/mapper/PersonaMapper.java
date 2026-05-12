package com.caixaba.absis.microalumnos.mapper;

import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
	//crea un mapper que convierta entre Alumno y AlumnoEntity
	public com.capgemini.microalumnos.api.domain.Alumno toAlumno(com.caixaba.absis.microalumnos.entity.AlumnoEntity alumnoEntity) {
		if (alumnoEntity == null) {
			return null;
		}
		com.capgemini.microalumnos.api.domain.Alumno alumno = new com.capgemini.microalumnos.api.domain.Alumno();
		alumno.setDni(alumnoEntity.getDni());
		alumno.setNombre(alumnoEntity.getNombre());
		alumno.setCurso(alumnoEntity.getCurso());
		alumno.setCalificacion(alumnoEntity.getNota());
		return alumno;
	}
	
	public com.caixaba.absis.microalumnos.entity.AlumnoEntity toAlumnoEntity(com.capgemini.microalumnos.api.domain.Alumno alumno) {
		if (alumno == null) {
			return null;
		}
		com.caixaba.absis.microalumnos.entity.AlumnoEntity alumnoEntity = new com.caixaba.absis.microalumnos.entity.AlumnoEntity();
		alumnoEntity.setDni(alumno.getDni());
		alumnoEntity.setNombre(alumno.getNombre());
		alumnoEntity.setCurso(alumno.getCurso());
		alumnoEntity.setNota(alumno.getCalificacion());
		return alumnoEntity;
	}
}
