package com.dh.SessionBookingSystem.entity;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String email;
    private String contrasenia;
    private String repetirContrasenia;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String email, String contrasenia, String repetirContrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.repetirContrasenia = repetirContrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRepetirContrasenia() {
        return repetirContrasenia;
    }

    public void setRepetirContrasenia(String repetirContrasenia) {
        this.repetirContrasenia = repetirContrasenia;
    }

}
