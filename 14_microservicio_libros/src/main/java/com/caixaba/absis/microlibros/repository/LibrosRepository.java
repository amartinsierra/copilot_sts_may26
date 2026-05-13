package com.caixaba.absis.microlibros.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.caixaba.absis.microlibros.entity.LibroEntity;

public interface LibrosRepository extends JpaRepository<LibroEntity, Long> {
    List<LibroEntity> findByPrecioBetween(Double precioMin, Double precioMax);
}
