package com.caixaba.absis.microalumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixaba.absis.microalumnos.entity.AlumnoEntity;

public interface AlumnosRepository extends JpaRepository<AlumnoEntity, Long> {
//crea los métodos para poder implementar la funcionalidad definida en el servicio, como findByCurso, findAllCursos y updateCalificacionesByCurso
	java.util.List<AlumnoEntity> findByCurso(String curso);
	@org.springframework.data.jpa.repository.Query("SELECT DISTINCT a.curso FROM AlumnoEntity a")
	java.util.List<String> findAllCursos();
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("UPDATE AlumnoEntity a SET a.nota = CASE WHEN a.nota + :valor > 10 THEN 10 ELSE a.nota + :valor END WHERE a.curso = :curso")
	void updateCalificacionesByCurso(String curso, Double valor);
	//también un métodoque compruebe si existe una combinación dni curso
	boolean existsByDniAndCurso(String dni, String curso);
}
