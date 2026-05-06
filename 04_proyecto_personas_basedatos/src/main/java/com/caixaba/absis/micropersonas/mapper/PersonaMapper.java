package com.caixaba.absis.micropersonas.mapper;

import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
	//método para convertir de PersonaEntity a Persona
	public com.capgemini.micropersonas.api.domain.Persona toPersona(com.caixaba.absis.micropersonas.entity.PersonaEntity personaEntity) {
		if (personaEntity == null) {
			return null;
		}
		com.capgemini.micropersonas.api.domain.Persona persona = new com.capgemini.micropersonas.api.domain.Persona();
		persona.setId(personaEntity.getId());
		persona.setNombre(personaEntity.getNombre());
		persona.setEdad(personaEntity.getEdad());
		persona.setEmail(personaEntity.getEmail());
		return persona;
	}
	
	//método para convertir de Persona a PersonaEntity
	public com.caixaba.absis.micropersonas.entity.PersonaEntity toPersonaEntity(com.capgemini.micropersonas.api.domain.Persona persona) {
		if (persona == null) {
			return null;
		}
		com.caixaba.absis.micropersonas.entity.PersonaEntity personaEntity = new com.caixaba.absis.micropersonas.entity.PersonaEntity();
		personaEntity.setId(persona.getId());
		personaEntity.setNombre(persona.getNombre());
		personaEntity.setEdad(persona.getEdad());
		personaEntity.setEmail(persona.getEmail());
		return personaEntity;
	}
}
