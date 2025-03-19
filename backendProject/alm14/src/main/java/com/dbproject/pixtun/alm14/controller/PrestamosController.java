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

import com.dbproject.pixtun.alm14.model.entity.Prestamos;
import com.dbproject.pixtun.alm14.service.PrestamosService;


@RestController
@CrossOrigin(origins = {"http://localhost:5545", "https://localhost:9090"})
public class PrestamosController {
    @Autowired
    private PrestamosService prestamosService;

    @GetMapping("api/list_prestamos") // READ (lectura de la tabla)
    public List<Prestamos> getAllPrestamos() {
        return prestamosService.getAllPrestamos();
    }

    @GetMapping("api/list_prestamos_id") // READ (lectura de registro por id con RequestParam)
    public Prestamos getPrestamosesByIdRequestParam(@RequestParam("id") Integer prestamosId) {
    // Lógica para obtener el prestamos por su ID utilizando el servicio PrestamosService
    Optional<Prestamos> prestamosOptional = prestamosService.findById(prestamosId);
    return prestamosOptional.orElse(null);
}

@GetMapping("api/list_prestamos_id/{id}") // READ (lectura de registro por id con PathVariable)
    public Prestamos getPrestamosByIdPathVariable(@PathVariable("id") Integer prestamosId) {
        // Lógica para obtener el prestamos por su ID utilizando el servicio PrestamosService
        Optional<Prestamos> prestamosOptional = prestamosService.findById(prestamosId);
        return prestamosOptional.orElse(null);
    }

    @PostMapping("api/create_prestamos")
    public Prestamos createPrestamos(@RequestBody Prestamos prestamos) {
        // Lógica para crear un nuevo prestamos utilizando el servicio PrestamosService
        return prestamosService.save(prestamos);
    }

 
    @PutMapping("/prestamos/{id}")
    public Prestamos updatePrestamos(@PathVariable("id") Integer prestamosId, @RequestBody Prestamos updatedPrestamos) {
        // Lógica para buscar y actualizar un prestamos existente utilizando el servicio PrestamosService
        Optional<Prestamos> prestamosOptional = prestamosService.findById(prestamosId);
        if (prestamosOptional.isPresent()) {
            Prestamos prestamos = prestamosOptional.get();
            prestamos.setUsuario(updatedPrestamos.getUsuario());
            prestamos.setLibro(updatedPrestamos.getLibro());
            prestamos.setFechaPrestamo(updatedPrestamos.getFechaPrestamo());
            prestamos.setFechaDevolucionPrevista(updatedPrestamos.getFechaDevolucionPrevista());
            prestamos.setFechaDevolucionReal(updatedPrestamos.getFechaDevolucionReal());
            return prestamosService.save(prestamos);
        } else {
            return null; // O manejar el caso cuando no se encuentra el usuario
        }
    }
    @DeleteMapping("/prestamos/{id}")
    public void deletePrestamos(@PathVariable("id") Integer prestamosId) {
    // Lógica para eliminar un prestamos existente utilizando el servicio PrestamosService
    Optional<Prestamos> prestamosOptional = prestamosService.findById(prestamosId);
    prestamosOptional.ifPresent(prestamosService::delete);
}
}
