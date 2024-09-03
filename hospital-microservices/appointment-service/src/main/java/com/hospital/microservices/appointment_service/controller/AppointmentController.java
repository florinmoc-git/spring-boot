package com.hospital.microservices.appointment_service.controller;

import com.hospital.microservices.appointment_service.client.PatientClient;
import com.hospital.microservices.appointment_service.dto.AppointmentDto;
import com.hospital.microservices.appointment_service.entity.Patient;
import com.hospital.microservices.appointment_service.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientClient patientClient;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDto createAppointment(@Valid @RequestBody AppointmentDto appointment) {
        return appointmentService.createAppointment(appointment).toDto();
    }

    @GetMapping
    public Patient getPatient(@RequestParam Long patientId) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return patientClient.getPatient(patientId);
    }
}
