package com.dh.sistemaGestionClinica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer number;
    private String town;
    private String state;

    public Address() {
    }

    public Address(Integer id, String street, Integer number, String town, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.town = town;
        this.state = state;
    }

}
