package com.dh.SessionBookingSystem.controller.managePatients;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savePatient")

public class SavePatientController {

    private PatientService patientService;

    @Autowired
    public SavePatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Patient patient) {
        patientService.save(patient);
        return ResponseEntity.status(200).body("Add patient with id: " + patient.getId() + ", name: " + patient.getName() + ", last name: " + patient.getLastName() + ", dni: " + patient.getDni() + ", entry date: " + patient. getEntryDate() + ".");
    }

}
