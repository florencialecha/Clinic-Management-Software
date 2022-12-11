package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.entity.Appointment;
import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    public Optional<AppointmentDTO> findById(Long id) {
    }

    private AppointmentDTO appointmentToAppointmentDTO(Appointment appointment) {
        AppointmentDTO response = new AppointmentDTO();
        response.setId(appointment.getId());
        response.setAppointmentDate(appointment.getAppointmentDate());
        response.setDentistId(appointment.getDentist().getId());
        response.setPatientId(appointment.getPatient().getId());
        return response;
    }
    private Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = new Appointment();
        Patient patient = new Patient();
        Dentist dentist = new Dentist();

        patient.setId(appointmentDTO.getId());
        dentist.setId(appointmentDTO.getDentistId());

        appointment.setId(appointmentDTO.getId());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());

        return appointment;
    }

    private AppointmentDTO appointment
}
