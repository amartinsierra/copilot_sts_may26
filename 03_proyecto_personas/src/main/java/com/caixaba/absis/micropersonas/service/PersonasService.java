package com.caixaba.absis.micropersonas.service;

import java.util.List;

import com.capgemini.micropersonas.api.domain.Persona;

public interface PersonasService {
	List<Persona> getPersonas();
	Persona getPersonaById(Integer id);
	Persona createPersona(Persona persona);
	Persona deletePersona(Integer id);
	List<Persona> getPersonasByEdadRange(Integer min, Integer max);
}
