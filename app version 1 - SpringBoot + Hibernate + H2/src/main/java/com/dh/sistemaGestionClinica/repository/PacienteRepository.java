package com.dh.sistemaGestionClinica.repository;

import com.dh.sistemaGestionClinica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Patient, Long> {
}
