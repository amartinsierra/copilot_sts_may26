package com.caixaba.absis.microlibros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.caixaba.absis.microlibros.entity.LibroEntity;
import com.caixaba.absis.microlibros.exception.LibroExistsException;
import com.caixaba.absis.microlibros.mapper.LibroMapper;
import com.caixaba.absis.microlibros.repository.LibrosRepository;
import com.capgemini.microlibros.dto.LibroDto;

@Service
public class LibrosServiceImpl implements LibrosService {

    private final LibrosRepository repository;
    private final LibroMapper mapper;

    public LibrosServiceImpl(LibrosRepository repository, LibroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<LibroDto> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibroDto> buscarPorRangoPrecios(Double precioMin, Double precioMax) {
        return repository.findByPrecioBetween(precioMin, precioMax).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibroDto guardarLibro(LibroDto libro) {
        if (repository.existsById(libro.isbn())) {
            throw new LibroExistsException("El libro con ISBN " + libro.isbn() + " ya existe.");
        }
        LibroEntity entity = mapper.toEntity(libro);
        LibroEntity savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public LibroDto eliminarLibro(Long isbn) {
        Optional<LibroEntity> libroOpt = repository.findById(isbn);
        if (libroOpt.isPresent()) {
            LibroEntity entity = libroOpt.get();
            repository.deleteById(isbn);
            return mapper.toDto(entity);
        }
        return null;
    }
}
