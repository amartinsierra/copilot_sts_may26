package com.capgemini.microlibros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entidad creada según skill
 */
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    private Integer idVenta;
    private Integer idCliente;
    private Integer idLibro;
    private LocalDateTime fecha;

    public Venta() {
    }

    public Venta(Integer idVenta, Integer idCliente, Integer idLibro, LocalDateTime fecha) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.fecha = fecha;
    }

    public Venta(Integer idCliente, Integer idLibro, LocalDateTime fecha) {
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.fecha = fecha;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
