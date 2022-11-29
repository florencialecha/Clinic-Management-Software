package com.dh.sistemaGestionClinica.controller.manageDentists;

import com.dh.sistemaGestionClinica.entity.Dentist;
import com.dh.sistemaGestionClinica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/deleteDentist")

public class DeleteDentistController {

    private DentistService dentistService;

    @Autowired
    public DeleteDentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteDentistById(@PathVariable Long id) {
        Optional<Dentist> searchDentist = dentistService.findById(id);
        if (searchDentist.isEmpty()) {
            ResponseEntity.status(404).body("Can't delete dentist with id: " + id + " . The dentist does not exist in the database.");
        }
        dentistService.deleteById(id);
        return ResponseEntity.status(200).body("Delete dentist with id: " + id);
    }
}
