package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
