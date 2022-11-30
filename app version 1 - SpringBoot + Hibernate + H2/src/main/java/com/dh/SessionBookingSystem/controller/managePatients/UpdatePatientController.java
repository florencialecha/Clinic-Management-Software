package com.dh.SessionBookingSystem.controller.managePatients;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/updatePatient")

public class UpdatePatientController {

    private PatientService patientService;

    @Autowired
    public UpdatePatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Patient patient) {
        Optional<Patient> searchPatient = patientService.findById(patient.getId());
        if (searchPatient.isEmpty()) {
            return ResponseEntity.status(400).body("Can't update dentist with id: " + patient.getId() + " . The dentist does not exist in the database.");
        }
        patientService.save(patient);
        return ResponseEntity.status(200).body("Update patient whit id: " + patient.getId() + ", name: " + patient.getName() + ".");
    }

}
