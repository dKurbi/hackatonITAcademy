package com.itacademy.hackaton.adapter.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DistrictController {

    @Bean
    public RouterFunction<ServerResponse> districtRouteFunctions() {

        return route(GET("/api/districts/"), this::getAllDistricts);

    }

    private Mono<ServerResponse> getAllDistricts(ServerRequest request) {


    }

}
