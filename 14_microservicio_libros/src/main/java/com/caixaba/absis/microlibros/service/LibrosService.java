package com.caixaba.absis.microlibros.service;

import java.util.List;
import com.capgemini.microlibros.dto.LibroDto;

public interface LibrosService {
    List<LibroDto> obtenerTodos();
    List<LibroDto> buscarPorRangoPrecios(Double precioMin, Double precioMax);
    LibroDto guardarLibro(LibroDto libro);
    LibroDto eliminarLibro(Long isbn);
}
