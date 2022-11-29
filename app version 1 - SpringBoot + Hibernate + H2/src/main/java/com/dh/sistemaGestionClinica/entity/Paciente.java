package com.dh.sistemaGestionClinica.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;
    private Integer dni;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "domicilio_id", nullable = false)
    //private Domicilio domicilio;
    private LocalDate fechaAlta;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, Domicilio domicilio, Integer dni, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        //this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //public Domicilio getDomicilio() {
        // return domicilio;
    //}

    //@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //private Set<Domicilio> domicilios = new HashSet<>();

    //public void setDomicilio(Domicilio domicilio) {
        //this.domicilio = domicilio;
    //}

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
