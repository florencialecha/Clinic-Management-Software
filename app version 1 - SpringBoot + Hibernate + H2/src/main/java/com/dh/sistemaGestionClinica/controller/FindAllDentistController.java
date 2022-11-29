package com.dh.sistemaGestionClinica.controller;

import com.dh.sistemaGestionClinica.entity.Dentist;
import com.dh.sistemaGestionClinica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/findAllDentist")

public class FindAllDentistController {

    private DentistService dentistService;

    @Autowired
    public FindAllDentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public List<Dentist> findAllDentist() {
        return dentistService.findAll();
    }
}
