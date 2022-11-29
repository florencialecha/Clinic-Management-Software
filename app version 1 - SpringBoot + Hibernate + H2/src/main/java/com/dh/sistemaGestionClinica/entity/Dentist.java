package com.dh.sistemaGestionClinica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String license;
    
    public Dentist() {
    }

    public Dentist(Long id, String name, String lastname, String license) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.license = license;
    }

}
