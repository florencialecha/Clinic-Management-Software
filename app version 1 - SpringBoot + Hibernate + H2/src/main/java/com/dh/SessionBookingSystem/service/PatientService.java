package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void save(Patient patient) {
       patientRepository.save(patient);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

}
