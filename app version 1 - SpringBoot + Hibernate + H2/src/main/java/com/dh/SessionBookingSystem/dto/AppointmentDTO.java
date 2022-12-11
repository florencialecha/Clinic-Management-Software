package com.dh.SessionBookingSystem.dto;

import com.dh.SessionBookingSystem.entity.Dentist;
import com.dh.SessionBookingSystem.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter

public class AppointmentDTO {

    private Long id;
    private Long patientId;
    private Long dentistId;
    private LocalDateTime appointmentDate;

}
