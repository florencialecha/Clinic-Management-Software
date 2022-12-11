package com.dh.SessionBookingSystem.controller.manageAppointments;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.service.AppointmentService;
import com.dh.SessionBookingSystem.service.DentistService;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/findAppointment")

public class FindByAppointmentController {

    private AppointmentService appointmentService;
    private DentistService dentistService;
    private PatientService patientService;

    @Autowired
    public FindByAppointmentController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    public ResponseEntity<Optional<AppointmentDTO>> findByAppointmentById(@RequestParam Long id) {
        Optional<AppointmentDTO> searchAppointmentDTO = appointmentService.findById(id);
        if (searchAppointmentDTO.isEmpty()) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(searchAppointmentDTO);
    }

}
