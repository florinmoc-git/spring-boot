package com.hospital.microservices.appointment_service.config;

import com.hospital.microservices.appointment_service.client.PatientClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${patient-service.url}")
    String patientServiceUrl;

    @Bean
    public PatientClient patientClient() {
        var restClient = RestClient.builder().baseUrl(patientServiceUrl).build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();

        return httpServiceProxyFactory.createClient(PatientClient.class);
    }
}
