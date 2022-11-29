package com.dh.sistemaGestionClinica.controller;

import com.dh.sistemaGestionClinica.entity.Dentist;
import com.dh.sistemaGestionClinica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/updateDentist")
public class UpdateDentistController {

    private DentistService dentistService;

    @Autowired
    public UpdateDentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Dentist dentist) {
        Optional<Dentist> searchDentist = dentistService.findById(dentist.getId());
        if (searchDentist.isEmpty()) {
            return ResponseEntity.status(404).body("Can't update dentist with id: " + dentist.getId() + " . The dentist does not exist in the database.");
        }
        dentistService.save(dentist);
        return ResponseEntity.status(200).body("Update dentist whit id: " + dentist.getId() + ", name: " + dentist.getName() + ", last name: " + dentist.getLastname() + ", register number: " + dentist.getLicense() + ".");
    }

}