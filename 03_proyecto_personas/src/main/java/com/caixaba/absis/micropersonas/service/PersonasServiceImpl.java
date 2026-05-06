package com.caixaba.absis.micropersonas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.micropersonas.api.domain.Persona;
@Service
public class PersonasServiceImpl implements PersonasService {
	//Crea una lista modificable de personas para simular una base de datos en memoria
	//con 6 personas de ejemplo
	private List<Persona> personas = new java.util.ArrayList<>(java.util.Arrays.asList(
			new Persona(1, "Juan", 25, "juan.gmail.com"),
			new Persona(2, "Maria", 30, "maria.gmail.com"),
			new Persona(3, "Pedro", 20, "pedro.gmail.com"),
			new Persona(4, "Ana", 35, "ana.gmail.com"),
			new Persona(5, "Luis", 28, "luis.gmail.com"),
			new Persona(6, "Sofia", 22, "sofia.gmail.com")
			));

	@Override
	public List<Persona> getPersonas() {
		return personas;
	}

	@Override
	public Persona getPersonaById(Integer id) {
		//utiliza programación funcional para buscar la persona con el id dado en la lista de personas
		return personas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Persona createPersona(Persona persona) {
		//comprueba que no exista una persona con el mismo id en la lista de personas
		//si no existe lo añade a la lista y lo devuelve, si existe genera una excepción PersonaAlreadyExistsException con el id de la persona
		if (getPersonaById(persona.getId()) == null) {
			personas.add(persona);
			return persona;
		} else {
			throw new com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException(persona.getId());
		}
		
	}

	@Override
	public Persona deletePersona(Integer id) {
		//elimina la persona con el id dado de la lista de personas y la devuelve, si no existe genera una excepción PersonaNotFoundException con el id de la persona
		Persona persona = getPersonaById(id);
		if (persona != null) {
			personas.remove(persona);
			return persona;
		} else {
			throw new com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException(id);
		}
	}

	@Override
	public List<Persona> getPersonasByEdadRange(Integer min, Integer max) {
		//utiliza programación funcional para filtrar las personas cuya edad esta entre min y max en la lista de personas
		return personas.stream().filter(p -> p.getEdad() >= min && p.getEdad() <= max).toList();
	}

}
