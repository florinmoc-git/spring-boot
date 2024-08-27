package com.hospital.microservices.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> patientServiceRoute() {
        return GatewayRouterFunctions.route("patient_service")
                .route(RequestPredicates.path("/api/patient"), HandlerFunctions.http("http://localhost:8080"))
                .route(RequestPredicates.path("/api/patient/{patientId}"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> appointmentServiceRoute() {
        return GatewayRouterFunctions.route("appointment_service")
                .route(RequestPredicates.path("/api/appointment"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }
}
