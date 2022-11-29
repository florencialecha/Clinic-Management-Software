package com.dh.SessionBookingSystem.entity;

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
    private String lastName;
    private String license;
    
    public Dentist() {
    }

    public Dentist(Long id, String name, String lastName, String license) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.license = license;
    }

}
