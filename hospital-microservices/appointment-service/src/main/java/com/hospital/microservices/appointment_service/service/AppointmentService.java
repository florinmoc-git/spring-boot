package com.hospital.microservices.appointment_service.service;

import com.hospital.microservices.appointment_service.client.PatientClient;
import com.hospital.microservices.appointment_service.dto.AppointmentDto;
import com.hospital.microservices.appointment_service.entity.Appointment;
import com.hospital.microservices.appointment_service.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;

    @Transactional
    public Appointment createAppointment(AppointmentDto appointmentDto) {
        var patient = patientClient.getPatient(appointmentDto.getPatientId());
        var appointment = new Appointment();
        appointment.setDateTime(appointmentDto.getDateTime());
        appointment.setDoctorId(appointmentDto.getDoctorId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setPatientFirstName(patient.getFirstName());
        appointment.setPatientLastName(patient.getLastName());
        appointment.setDepartment(appointmentDto.getDepartment());

        return appointmentRepository.save(appointment);
    }
}
