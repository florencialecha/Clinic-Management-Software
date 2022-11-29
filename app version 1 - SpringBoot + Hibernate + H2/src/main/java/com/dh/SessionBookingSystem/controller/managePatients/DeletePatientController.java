package com.dh.SessionBookingSystem.controller.managePatients;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/deletePatient")

public class DeletePatientController {

    private PatientService patientService;

    @Autowired
    public DeletePatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @DeleteMapping("{id}")
    private ResponseEntity<String> deletePatient(@PathVariable Long id) {
        Optional<Patient> searchPatient = patientService.findById(id);
        if (searchPatient.isEmpty()) {
            ResponseEntity.status(404).body("Can't delete patient with id: " + id + " . The patient does not exist in the database.");
        }
        patientService.deleteById(id);
        return ResponseEntity.status(200).body("Delete patient with id: " + id);
        }

}