package com.hospital.microservices.appointment_service;

import org.springframework.boot.SpringApplication;

public class TestAppointmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(AppointmentServiceApplication::main).with(com.hospital.microservices.appointment_service.TestcontainersConfiguration.class).run(args);
    }

}
