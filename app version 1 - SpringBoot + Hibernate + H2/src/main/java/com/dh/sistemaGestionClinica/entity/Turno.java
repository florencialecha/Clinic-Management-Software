package com.dh.sistemaGestionClinica.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table

public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "odontologo_id")
    private Dentist dentist;
    private LocalDateTime fechaTurno;

    public Turno() {
    }

    public Turno(Integer id, Patient patient, Dentist dentist, LocalDateTime fechaTurno) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPaciente() {
        return patient;
    }

    public void setPaciente(Patient patient) {
        this.patient = patient;
    }

    public Dentist getOdontologo() {
        return dentist;
    }

    public void setOdontologo(Dentist dentist) {
        this.dentist = dentist;
    }

    public LocalDateTime getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDateTime fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

}
