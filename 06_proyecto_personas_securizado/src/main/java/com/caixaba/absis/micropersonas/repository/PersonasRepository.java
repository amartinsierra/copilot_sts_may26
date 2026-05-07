package com.caixaba.absis.micropersonas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.caixaba.absis.micropersonas.entity.PersonaEntity;

public interface PersonasRepository extends JpaRepository<PersonaEntity, Integer> {
	//crea método para devolver personas por rango de edades
	List<PersonaEntity> findByEdadBetween(Integer edadMin, Integer edadMax);
	
	//método que devuelva el total de personas mayores de edad
	//mediante una instrucción JPQL debe devolver el número de personas mayores de edad (18 años o más)
	@Query("SELECT COUNT(p) FROM PersonaEntity p WHERE p.edad >= 18")
	Long countByEdadGreaterThanEqual();
	
}
