package com.hospital.microservices.appointment_service.client;

import com.hospital.microservices.appointment_service.entity.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PatientClient {

    @GetExchange("/api/patient/{patientId}")
    Patient getPatient(@PathVariable Long patientId);
}
