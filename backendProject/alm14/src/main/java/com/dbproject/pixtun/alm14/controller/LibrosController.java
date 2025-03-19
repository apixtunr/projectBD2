package com.dbproject.pixtun.alm14.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbproject.pixtun.alm14.model.entity.Libros;
import com.dbproject.pixtun.alm14.service.LibrosService;

@RestController
@CrossOrigin(origins = {"http://localhost:5545", "https://localhost:9090"})
public class LibrosController {
    @Autowired
    private LibrosService librosService;

    @GetMapping("api/list_libros") 
    public List<Libros> getAllLibros() {
        return librosService.getAllLibros();
    }

    @GetMapping("api/list_libros_id") 
    public Libros getLibrossByIdRequestParam(@RequestParam("id") Integer librosId) {
    Optional<Libros> librosOptional = librosService.findById(librosId);
    return librosOptional.orElse(null);
}

@GetMapping("api/list_libros_id/{id}") 
    public Libros getLibrosByIdPathVariable(@PathVariable("id") Integer librosId) {
        Optional<Libros> librosOptional = librosService.findById(librosId);
        return librosOptional.orElse(null);
    }

    @PostMapping("api/create_libros")
    public Libros createLibros(@RequestBody Libros libros) {
        return librosService.save(libros);
    }

    // PutMapping // UPDATE (actualiza un registro existente)
    @PutMapping("/libros/{id}")
    public Libros updateLibros(@PathVariable("id") Integer librosId, @RequestBody Libros updatedLibros) {
        // Lógica para buscar y actualizar un libros existente utilizando el servicio LibrosService
        Optional<Libros> librosOptional = librosService.findById(librosId);
        if (librosOptional.isPresent()) {
            Libros libros = librosOptional.get();
            libros.setTitulo(updatedLibros.getTitulo());
            libros.setAutor(updatedLibros.getAutor());
            libros.setEditorial(updatedLibros.getEditorial());
            libros.setAnioPublicacion(updatedLibros.getAnioPublicacion());
            libros.setEjemplaresDisponibles(updatedLibros.getEjemplaresDisponibles());
            return librosService.save(libros);
        } else {
            return null; // O manejar el caso cuando no se encuentra el libros
        }
    }

    @DeleteMapping("/libros/{id}")
    public void deleteLibross(@PathVariable("id") Integer librosId) {
    // Lógica para eliminar un libro existente utilizando el servicio LibrosService
    Optional<Libros> librosOptional = librosService.findById(librosId);
    librosOptional.ifPresent(librosService::delete);
}
}
