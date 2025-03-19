package com.dbproject.pixtun.alm14.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name = "userData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "user_Name", length = 15, nullable = false)
    private String userName;

    @Column(name = "password", length = 15, nullable = false)
    private String password;

    @Column(name = "role", length = 15, unique = true, nullable = false)
    private String role;

    @Column(name = "privileges", length = 75, unique = true, nullable = false)
    private String privileges;

    @Column(name = "user_Schema", length = 15)
    private String userSchema;

    @Column(name = "status", length = 15)
    private String status;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
