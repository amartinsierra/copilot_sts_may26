package com.caixaba.absis.micropersonas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caixaba.absis.micropersonas.mapper.PersonaMapper;
import com.caixaba.absis.micropersonas.repository.PersonasRepository;
import com.capgemini.micropersonas.api.domain.Persona;
@Service
public class PersonasServiceImpl implements PersonasService {
	//crear una variable PersonaMapper y una variable PersonasRepository e inyectarlas mediante el constructor
	//No utilices nombres cualificados de clases, importa las clases necesarias para evitarlo
	private final PersonaMapper personaMapper;
	private final PersonasRepository personasRepository;
	public PersonasServiceImpl(PersonaMapper personaMapper, PersonasRepository personasRepository) {
		this.personaMapper = personaMapper;
		this.personasRepository = personasRepository;
	}
	
	

	@Override
	public List<Persona> getPersonas() {
		//utiliza el repositorio para obtener todas las personas de la base de datos, conviértelas a Persona utilizando el mapper y devuélvelas como una lista
		return personasRepository.findAll().stream().map(personaMapper::toPersona).toList();
	}

	@Override
	public Persona getPersonaById(Integer id) {
		//utiliza el repositorio para obtener la persona con el id dado, conviértela a Persona utilizando el mapper y devuélvela
		return personasRepository.findById(id).map(personaMapper::toPersona).orElse(null);
	}

	@Override
	public Persona createPersona(Persona persona) {
		//comprueba que no exista una persona con el mismo id si existe genera una excepción PersonaAlreadyExistsException con el id de la persona, si no existe utiliza el repositorio para guardar la persona convertida a PersonaEntity utilizando el mapper y devuélvela convertida a Persona utilizando el mapper
		//y si no existe la añades y la devuelves
		if (personasRepository.existsById(persona.getId())) {
			throw new com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException(persona.getId());
		} else {
			return personaMapper.toPersona(personasRepository.save(personaMapper.toPersonaEntity(persona)));
		}
		
	}

	@Override
	public Persona deletePersona(Integer id) {
		//elimina la persona con el id dado de la lista de personas y la devuelve, si no existe genera una excepción PersonaNotFoundException con el id de la persona
		Persona persona = getPersonaById(id);
		if (persona != null) {
			personasRepository.deleteById(id);
			return persona;
		} else {
			throw new com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException(id);
		}
	}

	@Override
	public List<Persona> getPersonasByEdadRange(Integer min, Integer max) {
		//utiliza el repositorio para obtener las personas cuyo rango de edad está entre min y max, conviértelas a Persona utilizando el mapper y devuélvelas como una lista
		return personasRepository.findByEdadBetween(min, max).stream().map(personaMapper::toPersona).toList();
	}

}
