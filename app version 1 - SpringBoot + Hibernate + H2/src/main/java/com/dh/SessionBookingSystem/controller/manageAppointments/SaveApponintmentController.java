package com.dh.SessionBookingSystem.controller.manageAppointments;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.exception.BadRequestException;
import com.dh.SessionBookingSystem.service.AppointmentService;
import com.dh.SessionBookingSystem.service.DentistService;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saveAppointment")

public class SaveApponintmentController {

    private AppointmentService appointmentService;
    private DentistService dentistService;
    private PatientService patientService;

    @Autowired
    public SaveApponintmentController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> save(@RequestBody AppointmentDTO appointmentDTO) throws BadRequestException {

        ResponseEntity<AppointmentDTO> response;

/*        if (patientService.findById(appointmentDTO.getPatientId()).isEmpty() ||
            dentistService.findById(appointmentDTO.getDentistId()).isEmpty()) {
            throw new BadRequestException("Patient or dentist doesnt extist");

        } else appointmentService.save(appointmentDTO);

        return response = ResponseEntity.ok(appointmentService.save(appointmentDTO));
    }*/

        if (patientService.findById(appointmentDTO.getPatientId()).isPresent() &&
                dentistService.findById(appointmentDTO.getDentistId()).isPresent()) {
            response = ResponseEntity.ok(appointmentService.save(appointmentDTO));
        }
        else {
            throw new BadRequestException("Patient or dentist doesnt extist");
        }
        return response;
    }

}
