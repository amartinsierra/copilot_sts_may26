package com.caixaba.absis.micropersonas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.caixaba.absis.micropersonas.entity.PersonaEntity;
@ContextConfiguration(classes = {com.capgemini.micropersonas.Application.class})
@DataJpaTest
class PersonasRepositoryTest {

    @Autowired
    private PersonasRepository personasRepository;

    @BeforeEach
    void setUp() {
        personasRepository.saveAll(List.of(
            new PersonaEntity(1, "Persona 1", 10, "p1@test.com"),
            new PersonaEntity(2, "Persona 2", 17, "p2@test.com"),
            new PersonaEntity(3, "Persona 3", 18, "p3@test.com"),
            new PersonaEntity(4, "Persona 4", 25, "p4@test.com"),
            new PersonaEntity(5, "Persona 5", 40, "p5@test.com")
        ));
    }

    @Test
    void findByEdadBetweenReturnsPeopleInAgeRange() {
        List<PersonaEntity> result = personasRepository.findByEdadBetween(17, 25);
        assertEquals(3, result.size());
    }

    @Test
    void findByEdadBetweenReturnsEmptyWhenNoMatches() {
        List<PersonaEntity> result = personasRepository.findByEdadBetween(50, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void countByEdadGreaterThanEqualReturnsTotalAdults() {
        Long adultsCount = personasRepository.countByEdadGreaterThanEqual();
        assertEquals(3L, adultsCount);
    }
}
