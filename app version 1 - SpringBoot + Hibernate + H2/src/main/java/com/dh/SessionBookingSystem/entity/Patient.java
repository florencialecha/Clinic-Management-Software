package com.dh.SessionBookingSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter @Setter

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Integer dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Address address;
    private LocalDate entryDate;

    private String email;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> turnos= new HashSet<>();

    public Patient() {
    }

    public Patient(String name, String lastName, Integer dni, Address address, LocalDate entryDate) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.entryDate = entryDate;
    }

    public Patient(Long id, String name, String lastName, Address address, Integer dni, LocalDate entryDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        //this.address = address;
        this.dni = dni;
        this.entryDate = entryDate;
    }

}
