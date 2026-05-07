package com.caixaba.absis.microalumnos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.microalumnos.api.domain.Alumno;
import com.capgemini.microalumnos.exceptions.AlumnoAlreadyExistsException;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	private final com.caixaba.absis.microalumnos.mapper.PersonaMapper personaMapper;
	private final com.caixaba.absis.microalumnos.repository.AlumnosRepository alumnosRepository;
	public AlumnosServiceImpl(com.caixaba.absis.microalumnos.mapper.PersonaMapper personaMapper, com.caixaba.absis.microalumnos.repository.AlumnosRepository alumnosRepository) {
		this.personaMapper = personaMapper;
		this.alumnosRepository = alumnosRepository;
	}
	
	@Override
	public Alumno createAlumno(Alumno alumno) {
		//No se permitirá dar de alta un alumno con la misma combinación dni y curso. Devuelve el alumno añadido o lanza una excepción AlumnoAlreadyExistsException con el dni y el curso del alumno
		if (alumnosRepository.existsByDniAndCurso(alumno.getDni(), alumno.getCurso())) {
			throw new AlumnoAlreadyExistsException(alumno.getDni(), alumno.getCurso());
		} else {
			return personaMapper.toAlumno(alumnosRepository.save(personaMapper.toAlumnoEntity(alumno)));
		}
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return alumnosRepository.findAll().stream().map(personaMapper::toAlumno).toList();
	}

	@Override
	public List<Alumno> getAlumnosByCurso(String curso) {
		return alumnosRepository.findByCurso(curso).stream().map(personaMapper::toAlumno).toList();
	}

	@Override
	public List<String> getCursos() {
		return alumnosRepository.findAllCursos();
	}

	@Override
	public void updateCalificaciones(String curso, Double valor) {
		//Se recibe como parámetro el nombre del curso y un valor, y se suma dicho valor a las calificaciones de ese curso, siempre y cuando la suma no supere 10
		alumnosRepository.updateCalificacionesByCurso(curso, valor);

	}

}
