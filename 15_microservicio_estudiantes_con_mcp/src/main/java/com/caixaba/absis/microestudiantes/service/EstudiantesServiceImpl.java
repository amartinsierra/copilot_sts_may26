package com.caixaba.absis.microestudiantes.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.capgemini.microestudiantes.api.domain.Estudiante;
import com.caixaba.absis.microestudiantes.entity.AlumnoExterno;

@Service
public class EstudiantesServiceImpl implements EstudiantesService {

	private final RestClient restClient;

	@Value("${remote.url}")
	private String urlBase;

	public EstudiantesServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public List<Estudiante> getEstudiantesByRangeNota(double minNota, double maxNota) {
		AlumnoExterno[] alumnos = restClient.get()
				.uri(urlBase + "/alumnos")
				.retrieve()
				.body(AlumnoExterno[].class);

		return Arrays.stream(alumnos)
				.filter(a -> a.getCalificacion() != null && a.getCalificacion() >= minNota && a.getCalificacion() <= maxNota)
				.map(this::mapToEstudiante)
				.collect(Collectors.toList());
	}

	@Override
	public void createEstudiante(Estudiante estudiante) {
		AlumnoExterno alumno = new AlumnoExterno();
		alumno.setNombre(estudiante.getNombre());
		if (estudiante.getNota() != null) {
			alumno.setCalificacion(estudiante.getNota().doubleValue());
		}

		try {
			restClient.post()
					.uri(urlBase + "/alumno")
					.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
					.body(alumno)
					.retrieve()
					.toBodilessEntity();
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido dar de alta al estudiante", e);
		}
	}

	private Estudiante mapToEstudiante(AlumnoExterno alumno) {
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre(alumno.getNombre());
		if (alumno.getCalificacion() != null) {
			estudiante.setNota(alumno.getCalificacion().floatValue());
		}
		return estudiante;
	}

}