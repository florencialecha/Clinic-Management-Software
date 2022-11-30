package com.dh.SessionBookingSystem.controller.managePatients;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/findPatient")

public class FindByPatientController {

    private PatientService patientService;

    @Autowired
    public FindByPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/byId")
    public ResponseEntity<Optional<Patient>> findPatientById(@RequestParam Long id) {
        Optional<Patient> searchPatient = patientService.findById(id);
        if (searchPatient.isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(searchPatient);
    }

    @GetMapping("/byNameAndLastName")
    public ResponseEntity<Optional<Patient>> findPatientByNameAndLastname(@RequestParam String name, String lastname) {
        Optional<Patient> searchPatient = patientService.findByNameAndLastname(name, lastname);
        if (searchPatient.isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(searchPatient);
    }
}
