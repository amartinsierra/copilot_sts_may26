package com.capgemini.micropersonas.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.caixaba.absis.micropersonas.service.PersonasService;
import com.capgemini.micropersonas.api.PersonasApi;
import com.capgemini.micropersonas.api.domain.Persona;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class PersonasController implements PersonasApi {
	//declara una variable de tipo PersonasService e inyecta su implementación mediante el constructor
	//no utilices nombres cualificados para las clases, solo el nombre de la clase sin el paquete
	private PersonasService personasService;
	public PersonasController(PersonasService personasService) {
		this.personasService = personasService;
	}
	

	@Override
	public ResponseEntity<List<Persona>> personasEdadesGet(@NotNull @Valid Integer min, @NotNull @Valid Integer max) {
		return ResponseEntity.ok(personasService.getPersonasByEdadRange(min, max));
	}

	@Override
	public ResponseEntity<List<Persona>> personasGet() {
		return ResponseEntity.ok(personasService.getPersonas());
	}

	@Override
	public ResponseEntity<Persona> personasIdDelete(Integer id) {
		//elimina la persona y la devuelve con codigo 200
		return ResponseEntity.ok(personasService.deletePersona(id));
	}

	@Override
	public ResponseEntity<Persona> personasIdGet(Integer id) {
		return ResponseEntity.ok(personasService.getPersonaById(id));
	}

	@Override
	public ResponseEntity<Persona> personasPost(@Valid Persona persona) {
		//añade la persona y la devuelve con codigo 201
		return ResponseEntity.status(201).body(personasService.createPersona(persona));
	}

}
