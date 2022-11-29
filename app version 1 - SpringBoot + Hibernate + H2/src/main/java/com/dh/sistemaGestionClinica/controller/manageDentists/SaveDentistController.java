package com.dh.sistemaGestionClinica.controller.manageDentists;

import com.dh.sistemaGestionClinica.entity.Dentist;
import com.dh.sistemaGestionClinica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saveDentist")
public class SaveDentistController {

    private DentistService dentistService;

    @Autowired
    public SaveDentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Dentist dentist) {
        dentistService.save(dentist);
        return ResponseEntity.status(200).body("Se agregó un nuevo odontólogo con nombre: " + dentist.getName() + ", apellido: " + dentist.getLastName() + ", matrícula: " + dentist.getLicense() + ", e id: " + dentist.getId() + ".");
        }
}
