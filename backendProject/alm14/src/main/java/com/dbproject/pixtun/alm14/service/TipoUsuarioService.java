package com.dbproject.pixtun.alm14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbproject.pixtun.alm14.model.entity.TipoUsuario;
import com.dbproject.pixtun.alm14.model.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
     private final TipoUsuarioRepository TipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository TipoUsuarioRepository)
    {
        this.TipoUsuarioRepository=TipoUsuarioRepository;
    }
    public List<TipoUsuario> getAllTipoUsuario()
    {
        return (List<TipoUsuario>) TipoUsuarioRepository.findAll();
    }
    public Optional<TipoUsuario> findById(Integer par_id) {
        return TipoUsuarioRepository.findById(par_id);
    }
    public TipoUsuario save(TipoUsuario par_usuario) {
        return TipoUsuarioRepository.save(par_usuario);
    }
    public void delete(TipoUsuario par_usuario) {
         TipoUsuarioRepository.delete(par_usuario);
        }
}
