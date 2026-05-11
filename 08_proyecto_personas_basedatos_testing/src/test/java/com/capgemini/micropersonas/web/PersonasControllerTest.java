package com.capgemini.micropersonas.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.caixaba.absis.micropersonas.service.PersonasService;
import com.capgemini.micropersonas.api.domain.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PersonasController.class)
class PersonasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PersonasService personasService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void personasGetReturnsAllPersonas() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Prueba");
        
        when(personasService.getPersonas()).thenReturn(List.of(persona));

        mockMvc.perform(get("/personas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Prueba"));
    }

    @Test
    void personasIdGetReturnsPersonaWhenExists() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        
        when(personasService.getPersonaById(1)).thenReturn(persona);

        mockMvc.perform(get("/personas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void personasPostCreatesNewPersona() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Nuevo");
        persona.setEdad(30);
        persona.setEmail("nuevo@test.com");

        when(personasService.createPersona(any(Persona.class))).thenReturn(persona);

        mockMvc.perform(post("/personas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void personasIdDeleteRemovesPersona() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        
        when(personasService.deletePersona(1)).thenReturn(persona);

        mockMvc.perform(delete("/personas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void personasEdadesGetReturnsFilteredPersonas() throws Exception {
        Persona persona = new Persona();
        persona.setId(1);
        persona.setEdad(25);

        when(personasService.getPersonasByEdadRange(20, 30)).thenReturn(List.of(persona));

        mockMvc.perform(get("/personas/edades")
                .param("min", "20")
                .param("max", "30")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].edad").value(25));
    }
}