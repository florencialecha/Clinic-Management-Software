package com.dh.SessionBookingSystem.controller.manageAppointments;

import com.dh.SessionBookingSystem.service.AppointmentService;
import com.dh.SessionBookingSystem.service.DentistService;
import com.dh.SessionBookingSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/deleteAppointment")

public class DeleteAppointmentController {

    private AppointmentService appointmentService;
    private DentistService dentistService;
    private PatientService patientService;

    @Autowired
    public DeleteAppointmentController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteAppointmentById(@PathVariable Long id) {
        if (appointmentService.findById(id).isEmpty()) {
            ResponseEntity.status(200).body("Can't delete appointment with id: " + id + ". The appointment doesn't exist.");
        }
        appointmentService.deleteById(id);
        return  ResponseEntity.status(200).body("Delete appointment with id: "+ id + ".");
    }
}
