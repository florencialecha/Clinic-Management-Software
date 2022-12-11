package com.dh.SessionBookingSystem.controller.managePatients;

import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findAllPatient")

public class FindAllPatientController {

    private PatientService patientService;

    @Autowired
    public FindAllPatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> findAllDentist() {
        return patientService.findAll();
    }
}
