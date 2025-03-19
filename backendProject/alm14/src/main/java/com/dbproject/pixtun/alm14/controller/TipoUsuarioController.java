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

import com.dbproject.pixtun.alm14.model.entity.TipoUsuario;
import com.dbproject.pixtun.alm14.service.TipoUsuarioService;


@RestController
@CrossOrigin(origins = {"http://localhost:5545", "https://localhost:9090"})
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipousuarioService;

    @GetMapping("api/list_tipousuarios") 
    public List<TipoUsuario> getAllTipoUsuarios() {
        return tipousuarioService.getAllTipoUsuario();
    }

    @GetMapping("api/list_tipousuarios_id") // READ (lectura de registro por id con RequestParam)
    public TipoUsuario getTipoUsuariosByIdRequestParam(@RequestParam("id") Integer tipousuarioId) {
    // Lógica para obtener el tipousuario por su ID utilizando el servicio TipoUsuarioService
    Optional<TipoUsuario> tipousuarioOptional = tipousuarioService.findById(tipousuarioId);
    return tipousuarioOptional.orElse(null);
}

@GetMapping("api/list_tipousuarios_id/{id}") // READ (lectura de registro por id con PathVariable)
    public TipoUsuario getTipoUsuarioByIdPathVariable(@PathVariable("id") Integer tipousuarioId) {
        // Lógica para obtener el tipousuario por su ID utilizando el servicio TipoUsuarioService
        Optional<TipoUsuario> tipousuarioOptional = tipousuarioService.findById(tipousuarioId);
        return tipousuarioOptional.orElse(null);
    }

    @PostMapping("api/create_tipousuarios")
    public TipoUsuario createTipoUsuario(@RequestBody TipoUsuario tipousuario) {
        // Lógica para crear un nuevo tipousuario utilizando el servicio TipoUsuarioService
        return tipousuarioService.save(tipousuario);
    }

    // PutMapping // UPDATE (actualiza un registro existente)
    @PutMapping("/tipousuarios/{id}")
    public TipoUsuario updateTipoUsuario(@PathVariable("id") Integer tipousuarioId, @RequestBody TipoUsuario updatedTipoUsuario) {
        // Lógica para buscar y actualizar un tipousuario existente utilizando el servicio TipoUsuarioService
        Optional<TipoUsuario> tipousuarioOptional = tipousuarioService.findById(tipousuarioId);
        if (tipousuarioOptional.isPresent()) {
            TipoUsuario tipousuario = tipousuarioOptional.get();
            tipousuario.setRol(updatedTipoUsuario.getRol());
            return tipousuarioService.save(tipousuario);
        } else {
            return null; // O manejar el caso cuando no se encuentra el usuario
        }
    }

    @DeleteMapping("/tipousuarios/{id}")
    public void deleteTipoUsuarios(@PathVariable("id") Integer tipousuarioId) {
    // Lógica para eliminar un tipousuario existente utilizando el servicio TipoUsuarioService
    Optional<TipoUsuario> tipousuarioOptional = tipousuarioService.findById(tipousuarioId);
    tipousuarioOptional.ifPresent(tipousuarioService::delete);
}
}
