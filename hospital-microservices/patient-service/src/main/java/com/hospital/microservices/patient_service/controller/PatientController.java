package com.hospital.microservices.patient_service.controller;

import com.hospital.microservices.patient_service.entities.Patient;
import com.hospital.microservices.patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping(path = "/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatient(@PathVariable Long patientId) {
        return patientService.getPatient(patientId);
    }
}
