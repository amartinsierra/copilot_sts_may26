package com.capgemini.microlibros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad creada según skill
 */
@Entity
@Table(name = "temas")
public class Tema {
    @Id
    private Integer idTema;
    private String tema;

    public Tema() {
    }

    public Tema(Integer idTema, String tema) {
        this.idTema = idTema;
        this.tema = tema;
    }

    public Tema(String tema) {
        this.tema = tema;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
