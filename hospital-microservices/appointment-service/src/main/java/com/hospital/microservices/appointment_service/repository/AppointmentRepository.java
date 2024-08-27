package com.hospital.microservices.appointment_service.repository;

import com.hospital.microservices.appointment_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
