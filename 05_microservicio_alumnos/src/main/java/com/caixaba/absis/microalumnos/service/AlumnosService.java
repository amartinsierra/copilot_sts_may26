package com.caixaba.absis.microalumnos.service;

public interface AlumnosService {
	//crea una interfaz con los métodos createAlumno, getAllAlumnos, getAlumnosByCurso, getCursos y updateCalificaciones, pero usa nombres simples de clase y luego importa, NO nombres cualificados
	com.capgemini.microalumnos.api.domain.Alumno createAlumno(com.capgemini.microalumnos.api.domain.Alumno alumno);
	java.util.List<com.capgemini.microalumnos.api.domain.Alumno> getAllAlumnos();
	java.util.List<com.capgemini.microalumnos.api.domain.Alumno> getAlumnosByCurso(String curso);
	java.util.List<String> getCursos();
	void updateCalificaciones(String curso, Double valor);	
	
}
