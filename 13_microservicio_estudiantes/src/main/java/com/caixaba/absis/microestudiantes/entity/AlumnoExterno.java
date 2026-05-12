package com.caixaba.absis.microestudiantes.entity;

public class AlumnoExterno {
    private String nombre;
    private Double calificacion;

    public AlumnoExterno() {}

    public AlumnoExterno(String nombre, Double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
