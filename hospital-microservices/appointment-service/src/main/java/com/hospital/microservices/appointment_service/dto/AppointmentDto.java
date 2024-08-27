package com.hospital.microservices.appointment_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospital.microservices.appointment_service.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime dateTime;
    private Long doctorId;
    private Long patientId;
    private String department;

    public AppointmentDto(Appointment appointment) {
        this.id = appointment.getId();
        this.dateTime = appointment.getDateTime();
        this.doctorId = appointment.getDoctorId();
        this.patientId = appointment.getPatientId();
        this.department = appointment.getDepartment();
    }
}
