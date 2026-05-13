package com.capgemini.microlibros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad creada según skill
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private Integer idCliente;
    private String usuario;
    private String password;
    private String email;
    private Integer telefono;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String usuario, String password, String email, Integer telefono) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente(String usuario, String password, String email, Integer telefono) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
