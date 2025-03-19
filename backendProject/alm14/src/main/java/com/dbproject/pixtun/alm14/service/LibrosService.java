package com.dbproject.pixtun.alm14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbproject.pixtun.alm14.model.entity.Libros;
import com.dbproject.pixtun.alm14.model.repository.LibrosRepository;


@Service
public class LibrosService {
    private final LibrosRepository librosRepository;

    public LibrosService(LibrosRepository librosRepository)
    {
        this.librosRepository=librosRepository;
    }
    public List<Libros> getAllLibros()
    {
        return (List<Libros>) librosRepository.findAll();
    }
    public Optional<Libros> findById(Integer par_id) {
        return librosRepository.findById(par_id);
    }
    public Libros save(Libros libro) {
        return librosRepository.save(libro);
    }
    public void delete(Libros libro) {
         librosRepository.delete(libro);
        }

        
}
