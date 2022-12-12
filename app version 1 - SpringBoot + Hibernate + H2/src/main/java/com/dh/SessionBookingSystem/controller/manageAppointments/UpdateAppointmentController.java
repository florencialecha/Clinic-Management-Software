package com.dh.SessionBookingSystem.controller.manageAppointments;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.service.AppointmentService;
import com.dh.SessionBookingSystem.service.DentistService;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/updateAppointment")

public class UpdateAppointmentController {

    private AppointmentService appointmentService;
    private DentistService dentistService;
    private PatientService patientService;

    @PutMapping
    public ResponseEntity<String> update(@RequestBody AppointmentDTO appointmentDTO) {

        ResponseEntity<AppointmentDTO> response;

        if (appointmentService.findById(appointmentDTO.getId()).isEmpty()) {
            return ResponseEntity.status(400).body("Can't update appointment with id: "+ appointmentDTO.getId() + ". The appointment doesn't exist.");
        }
        else if (patientService.findById(appointmentDTO.getPatientId()).isEmpty() || dentistService.findById(appointmentDTO.getDentistId()).isEmpty()) {
            return ResponseEntity.status(400).body("Can't update appointment with id: "+ appointmentDTO.getId() + ". The dentist or patient doesn't exist.");
        }
        appointmentService.update(appointmentDTO);
        return ResponseEntity.status(200).body("Update appointment with id: " + appointmentDTO.getId());
    }
}
