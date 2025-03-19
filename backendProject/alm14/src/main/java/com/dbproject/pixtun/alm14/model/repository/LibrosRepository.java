package com.dbproject.pixtun.alm14.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbproject.pixtun.alm14.model.entity.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {
    Optional<Libros> findById(Integer id);
}


