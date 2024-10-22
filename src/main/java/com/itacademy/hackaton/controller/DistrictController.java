package com.itacademy.hackaton.controller;

import com.itacademy.hackaton.entity.IncomeResponseModel;
import com.itacademy.hackaton.service.DistrictCrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictCrudService districtCrudService;

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/districts",
                    operation = @Operation(
                            summary = "Get all districts",
                            description = "Returns a list of all districts with their income data",
                            operationId = "getAllDistricts",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "List of districts",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    array = @ArraySchema(schema = @Schema(implementation = IncomeResponseModel.class))
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "No districts found",
                                            content = @Content(schema = @Schema())
                                    ),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Internal server error",
                                            content = @Content(schema = @Schema())
                                    )
                            }
                    )
            )
    })

    public RouterFunction<ServerResponse> districtRouteFunctions() {

        return route(GET("/api/districts/"), this::getAllDistricts)
                .andRoute(GET("/api/districts/infantil"), this::getInfantilPercentage)
                .andRoute(GET("/api/districts/primary"), this::getPrimaryPercentage)
                .andRoute(GET("/api/districts/secondary"), this::getSeccondaryPercentage);

    }

    private Mono<ServerResponse> getSeccondaryPercentage(ServerRequest request) {

        return districtCrudService.getSecondaryPercentage()

                .collectList()

                // Response
                .flatMap(incomeResponseModel -> ok().contentType(APPLICATION_JSON).bodyValue(incomeResponseModel));

    }

    private Mono<ServerResponse> getPrimaryPercentage(ServerRequest request) {

        return districtCrudService.getPrimaryPercentage()

                .collectList()

                // Response
                .flatMap(incomeResponseModel -> ok().contentType(APPLICATION_JSON).bodyValue(incomeResponseModel));

    }

    private Mono<ServerResponse> getInfantilPercentage(ServerRequest request) {

        return districtCrudService.getInfantilPercentage()

                .collectList()

                // Response
                .flatMap(incomeResponseModel -> ok().contentType(APPLICATION_JSON).bodyValue(incomeResponseModel));

    }

    private Mono<ServerResponse> getAllDistricts(ServerRequest request) {

        return districtCrudService.getAllDistricts()

                .collectList()

                // Response
                .flatMap(incomeResponseModel -> ok().contentType(APPLICATION_JSON).bodyValue(incomeResponseModel));

    }

}
