package com.dh.sistemaGestionClinica.repository;

import com.dh.sistemaGestionClinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
