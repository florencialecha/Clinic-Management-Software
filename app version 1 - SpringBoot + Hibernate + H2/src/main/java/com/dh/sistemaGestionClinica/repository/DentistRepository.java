package com.dh.sistemaGestionClinica.repository;

import com.dh.sistemaGestionClinica.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistRepository extends JpaRepository<Dentist, Long> {


    Optional<Dentist> findByNameAndLastname(String name, String lastname);
}
