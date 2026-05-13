package com.capgemini.microlibros.dto;

public record LibroDto(
    Long isbn,
    String titulo,
    String tematica,
    Double precio
) {}
