package com.dh.SessionBookingSystem.controller.manageDentists;

import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("findDentist")

public class FindByDentistController {

    private DentistService dentistService;

    @Autowired
    public FindByDentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("byId")
    public ResponseEntity<Optional<Dentist>> findDentistById(@RequestParam Long id) {
        Optional<Dentist> searchDentist = dentistService.findById(id);
        if (searchDentist.isEmpty()) {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.status(200).body(searchDentist);
    }

    @GetMapping("byNameAndLastName")
    public ResponseEntity<Optional<Dentist>> findDentistByNameAndLastname(@RequestParam String name, String lastname) {
        Optional<Dentist> searchDentist = dentistService.findByNameAndLastname(name, lastname);
        if (searchDentist.isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(searchDentist);
    }

}
