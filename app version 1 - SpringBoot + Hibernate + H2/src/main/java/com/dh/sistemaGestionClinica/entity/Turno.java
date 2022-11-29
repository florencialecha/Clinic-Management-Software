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
    private Paciente paciente;
    @OneToOne
    @JoinColumn(name = "odontologo_id")
    private Dentist dentist;
    private LocalDateTime fechaTurno;

    public Turno() {
    }

    public Turno(Integer id, Paciente paciente, Dentist dentist, LocalDateTime fechaTurno) {
        this.id = id;
        this.paciente = paciente;
        this.dentist = dentist;
        this.fechaTurno = fechaTurno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
