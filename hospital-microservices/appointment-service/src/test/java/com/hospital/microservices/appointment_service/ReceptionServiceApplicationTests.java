package com.hospital.microservices.appointment_service;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.MySQLContainer;

import static com.hospital.microservices.appointment_service.stubs.PatientClientStub.stubPatientCall;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class AppointmentServiceApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	MariaDBContainer<?> mariaDbContainer;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
		mariaDbContainer.start();
	}

	@Test
	void shouldCreateAnAppointment() {

		String requestBody = """
				{
				    "dateTime": "15.08.2024 14:15",
				    "doctorId": 1234,
				    "patientId": 1,
				    "department": "Cardiology"
				}
			""";

		stubPatientCall(1L);

		RestAssured
				.given()
					.contentType("application/json")
					.body(requestBody)
				.when()
					.post("api/appointment")
				.then()
					.statusCode(201)
					.body("id", notNullValue())
					.body("dateTime", equalTo("15.08.2024 14:15"))
					.body("doctorId", equalTo(1234))
					.body("patientId", equalTo(1))
					.body("department", equalTo("Cardiology"));
	}

}
