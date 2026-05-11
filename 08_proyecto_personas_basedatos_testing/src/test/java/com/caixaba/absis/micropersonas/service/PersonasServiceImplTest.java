package com.caixaba.absis.micropersonas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.caixaba.absis.micropersonas.entity.PersonaEntity;
import com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException;
import com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException;
import com.caixaba.absis.micropersonas.mapper.PersonaMapper;
import com.caixaba.absis.micropersonas.repository.PersonasRepository;
import com.capgemini.micropersonas.api.domain.Persona;

@ExtendWith(MockitoExtension.class)
class PersonasServiceImplTest {

    @Mock
    private PersonaMapper personaMapper;

    @Mock
    private PersonasRepository personasRepository;

    @InjectMocks
    private PersonasServiceImpl personasService;

    @Test
    void getPersonasReturnsListOfPersonas() {
        PersonaEntity entity = new PersonaEntity();
        Persona persona = new Persona();
        when(personasRepository.findAll()).thenReturn(List.of(entity));
        when(personaMapper.toPersona(entity)).thenReturn(persona);

        List<Persona> result = personasService.getPersonas();

        assertEquals(1, result.size());
        verify(personasRepository).findAll();
    }

    
    @Test
    void getPersonaByIdReturnsPersonaWhenExists() {
        PersonaEntity entity = new PersonaEntity();
        Persona persona = new Persona();
        when(personasRepository.findById(1)).thenReturn(Optional.of(entity));
        when(personaMapper.toPersona(entity)).thenReturn(persona);

        Persona result = personasService.getPersonaById(1);

        assertNotNull(result);
        verify(personasRepository).findById(1);
    }

    @Test
    void getPersonaByIdReturnsNullWhenNotExists() {
        when(personasRepository.findById(1)).thenReturn(Optional.empty());

        Persona result = personasService.getPersonaById(1);

        assertNull(result);
    }

    @Test
    void createPersonaReturnsSavedPersonaWhenNotExists() {
        Persona persona = new Persona();
        persona.setId(1);
        PersonaEntity entity = new PersonaEntity();
        
        when(personasRepository.existsById(1)).thenReturn(false);
        when(personaMapper.toPersonaEntity(persona)).thenReturn(entity);
        when(personasRepository.save(entity)).thenReturn(entity);
        when(personaMapper.toPersona(entity)).thenReturn(persona);

        Persona result = personasService.createPersona(persona);

        assertNotNull(result);
        verify(personasRepository).save(entity);
    }

    @Test
    void createPersonaThrowsExceptionWhenAlreadyExists() {
        Persona persona = new Persona();
        persona.setId(1);
        when(personasRepository.existsById(1)).thenReturn(true);

        assertThrows(PersonaAlreadyExistsException.class, () -> personasService.createPersona(persona));
        verify(personasRepository, never()).save(any());
    }

    @Test
    void deletePersonaReturnsDeletedPersonaWhenExists() {
        PersonaEntity entity = new PersonaEntity();
        Persona persona = new Persona();
        when(personasRepository.findById(1)).thenReturn(Optional.of(entity));
        when(personaMapper.toPersona(entity)).thenReturn(persona);

        Persona result = personasService.deletePersona(1);

        assertNotNull(result);
        verify(personasRepository).deleteById(1);
    }

    @Test
    void deletePersonaThrowsExceptionWhenNotExists() {
        when(personasRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PersonaNotFoundException.class, () -> personasService.deletePersona(1));
        verify(personasRepository, never()).deleteById(1);
    }

    @Test
    void getPersonasByEdadRangeReturnsFilteredList() {
        PersonaEntity entity = new PersonaEntity();
        Persona persona = new Persona();
        when(personasRepository.findByEdadBetween(10, 20)).thenReturn(List.of(entity));
        when(personaMapper.toPersona(entity)).thenReturn(persona);

        List<Persona> result = personasService.getPersonasByEdadRange(10, 20);

        assertEquals(1, result.size());
        verify(personasRepository).findByEdadBetween(10, 20);
    }
}
