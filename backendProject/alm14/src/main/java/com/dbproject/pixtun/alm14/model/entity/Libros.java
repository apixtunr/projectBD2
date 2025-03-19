package com.dbproject.pixtun.alm14.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libros_seq_gen")
    @SequenceGenerator(name = "libros_seq_gen", sequenceName = "libros_seq", allocationSize = 1)
    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "autor", length = 75)
    private String autor;

    @Column(name = "editorial", length = 50)
    private String editorial;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @Column(name = "ejemplares_disponibles")
    private Integer ejemplaresDisponibles;

}

