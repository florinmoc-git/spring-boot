package com.hospital.microservices.appointment_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class PatientClientStub {
    static String patient = """
				{
                    "id": 1,
				    "title": "Mr",
				    "firstName": "Jim",
				    "lastName": "Elliot",
				    "address": {
				        "number": 124,
				        "street": "Soveja",
				        "city": "Constanta",
				        "county": "Constanta",
				        "postcode": "123454",
				        "country": "Romania"
				    },
				    "dob": "10.11.2012",
				    "phone": "0765569434",
				    "email": "jim@elliot.com",
				    "weight": 80,
				    "height": 1.80,
				    "wardId": 5
				}
				""";

    public static void stubPatientCall(Long patientId) {
        stubFor(get(urlEqualTo("/api/patient/" + patientId))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(patient)));
    }
}
