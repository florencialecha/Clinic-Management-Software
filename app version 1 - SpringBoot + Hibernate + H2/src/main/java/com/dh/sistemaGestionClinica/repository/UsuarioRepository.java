package com.dh.sistemaGestionClinica.repository;

import com.dh.sistemaGestionClinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
