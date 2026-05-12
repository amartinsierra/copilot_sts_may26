package com.caixaba.absis.microestudiantes.service;

import java.util.List;

import com.capgemini.microestudiantes.api.domain.Estudiante;

public interface EstudiantesService {
	List<Estudiante> getEstudiantesByRangeNota(double minNota, double maxNota);
	void createEstudiante(Estudiante estudiante);
}
