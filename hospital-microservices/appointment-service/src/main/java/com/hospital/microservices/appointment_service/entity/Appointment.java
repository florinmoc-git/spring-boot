package com.hospital.microservices.appointment_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospital.microservices.appointment_service.dto.AppointmentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime dateTime;
    private Long doctorId;
    private Long patientId;
    private String patientFirstName;
    private String patientLastName;
    private String department;

    public AppointmentDto toDto() {
        return new AppointmentDto(this);
    }
}
