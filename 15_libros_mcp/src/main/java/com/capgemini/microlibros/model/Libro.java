package com.capgemini.microlibros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad creada según skill
 */
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private Integer isbn;
    private String titulo;
    private String autor;
    private Double precio;
    private Integer paginas;
    private Integer idTema;

    public Libro() {
    }

    public Libro(Integer isbn, String titulo, String autor, Double precio, Integer paginas, Integer idTema) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.paginas = paginas;
        this.idTema = idTema;
    }

    public Libro(String titulo, String autor, Double precio, Integer paginas, Integer idTema) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.paginas = paginas;
        this.idTema = idTema;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }
}
