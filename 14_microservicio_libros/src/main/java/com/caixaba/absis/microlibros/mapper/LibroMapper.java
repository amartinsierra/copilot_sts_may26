package com.caixaba.absis.microlibros.mapper;

import org.mapstruct.Mapper;

import com.caixaba.absis.microlibros.entity.LibroEntity;
import com.capgemini.microlibros.dto.LibroDto;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    LibroDto toDto(LibroEntity entity);
    LibroEntity toEntity(LibroDto dto);
}
