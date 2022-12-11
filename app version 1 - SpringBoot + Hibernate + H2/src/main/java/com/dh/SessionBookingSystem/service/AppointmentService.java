package com.dh.SessionBookingSystem.service;

import com.dh.SessionBookingSystem.dto.AppointmentDTO;
import com.dh.SessionBookingSystem.entity.Appointment;
import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.entity.Patient;
import com.dh.SessionBookingSystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Optional<AppointmentDTO> findById(Long id) {
        Optional<Appointment> searchAppointment = appointmentRepository.findById(id);
        if (searchAppointment.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(appointmentToAppointmentDTO(searchAppointment.get()));
        }
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

}
