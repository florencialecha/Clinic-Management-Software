package com.dh.sistemaGestionClinica.service;

import com.dh.sistemaGestionClinica.entity.Dentist;
import com.dh.sistemaGestionClinica.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void save(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public void deleteById(Long id) {
        dentistRepository.deleteById(id);
    }

    public Optional<Dentist> findById(Long id) {
            return dentistRepository.findById(id);
    }

    public Optional<Dentist> findByNameAndLastname(String name, String lastname) {
        return dentistRepository.findByNameAndLastname(name, lastname);
    }

    public List<Dentist> findAll() { return dentistRepository.findAll();};

}
