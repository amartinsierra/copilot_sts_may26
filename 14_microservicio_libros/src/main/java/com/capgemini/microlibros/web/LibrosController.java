package com.capgemini.microlibros.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caixaba.absis.microlibros.service.LibrosService;
import com.capgemini.microlibros.dto.LibroDto;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    private final LibrosService service;

    public LibrosController(LibrosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LibroDto>> obtenerTodos() {
        return new ResponseEntity<>(service.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/rango")
    public ResponseEntity<List<LibroDto>> buscarPorRangoPrecios(
            @RequestParam("precioMin") Double precioMin, 
            @RequestParam("precioMax") Double precioMax) {
        return new ResponseEntity<>(service.buscarPorRangoPrecios(precioMin, precioMax), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroDto> guardarLibro(@RequestBody LibroDto libro) {
        return new ResponseEntity<>(service.guardarLibro(libro), HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<LibroDto> eliminarLibro(@PathVariable("isbn") Long isbn) {
        LibroDto libro = service.eliminarLibro(isbn);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
