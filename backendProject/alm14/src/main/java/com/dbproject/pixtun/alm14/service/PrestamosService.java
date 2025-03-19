package com.dbproject.pixtun.alm14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbproject.pixtun.alm14.model.entity.Prestamos;
import com.dbproject.pixtun.alm14.model.repository.PrestamosRepository;

@Service
public class PrestamosService {
    private final PrestamosRepository prestamosRepository;

    public PrestamosService(PrestamosRepository prestamosRepository)
    {
        this.prestamosRepository=prestamosRepository;
    }
    public List<Prestamos> getAllPrestamos()
    {
        return (List<Prestamos>) prestamosRepository.findAll();
    }
    public Optional<Prestamos> findById(Integer par_id) {
        return prestamosRepository.findById(par_id);
    }
    public Prestamos save(Prestamos par_prestamos) {
        return prestamosRepository.save(par_prestamos);
    }
    public void delete(Prestamos par_prestamos) {
         prestamosRepository.delete(par_prestamos);
        }
}

