package com.capgemini.microalumnos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad creada según skill
 */
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    private String nombreCurso;
    private Integer duracion;
    private LocalDate fechaInicio;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombreCurso, Integer duracion, LocalDate fechaInicio) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
    }

    public Curso(String nombreCurso, Integer duracion, LocalDate fechaInicio) {
        this.nombreCurso = nombreCurso;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
