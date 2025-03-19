package com.dbproject.pixtun.alm14.model.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamos_seq_gen")
    @SequenceGenerator(name = "prestamos_seq_gen", sequenceName = "prestamos_seq", allocationSize = 1)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserData usuario;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libros libro;

    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;

    @Column(name = "fecha_devolucion_prevista")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucionPrevista;

    @Column(name = "fecha_devolucion_real")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucionReal;
}

