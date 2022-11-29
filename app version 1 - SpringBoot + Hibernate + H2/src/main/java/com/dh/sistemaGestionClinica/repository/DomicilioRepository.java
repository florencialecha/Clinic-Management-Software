package com.dh.sistemaGestionClinica.repository;

import com.dh.sistemaGestionClinica.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Address, Integer> {
}
