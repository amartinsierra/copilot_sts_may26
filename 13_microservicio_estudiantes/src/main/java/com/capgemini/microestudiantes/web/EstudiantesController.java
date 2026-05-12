package com.capgemini.microestudiantes.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microestudiantes.api.EstudiantesApi;
import com.capgemini.microestudiantes.api.domain.Estudiante;
import com.caixaba.absis.microestudiantes.service.EstudiantesService;

@RestController
public class EstudiantesController implements EstudiantesApi {

	private final EstudiantesService service;

	public EstudiantesController(EstudiantesService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<Void> createEstudiante(Estudiante estudiante) {
		service.createEstudiante(estudiante);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Estudiante>> getEstudiantesByRangoNotas(Integer min, Integer max) {
		return ResponseEntity.ok(service.getEstudiantesByRangeNota(min, max));
	}

}
