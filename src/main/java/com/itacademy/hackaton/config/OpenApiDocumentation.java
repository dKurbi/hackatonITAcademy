package com.itacademy.hackaton.config;

import com.itacademy.hackaton.entity.IncomeResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocumentation {

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
            ),
            @RouterOperation(
                    path = "/api/districts/infantil",
                    operation = @Operation(
                            summary = "Get percentage of Infantil education",
                            description = "Returns the percentage of Infantil education in the districts",
                            operationId = "getInfantilPercentage",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Percentage of Infantil education",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    array = @ArraySchema(schema = @Schema(implementation = IncomeResponseModel.class))
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "No data found for Infantil percentage",
                                            content = @Content(schema = @Schema())
                                    ),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Internal server error",
                                            content = @Content(schema = @Schema())
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/districts/primary",
                    operation = @Operation(
                            summary = "Get percentage of Primary education",
                            description = "Returns the percentage of Primary education in the districts",
                            operationId = "getPrimaryPercentage",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Percentage of Primary education",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    array = @ArraySchema(schema = @Schema(implementation = IncomeResponseModel.class))
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "No data found for Primary percentage",
                                            content = @Content(schema = @Schema())
                                    ),
                                    @ApiResponse(
                                            responseCode = "500",
                                            description = "Internal server error",
                                            content = @Content(schema = @Schema())
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = "/api/districts/secondary",
                    operation = @Operation(
                            summary = "Get percentage of Secondary education",
                            description = "Returns the percentage of Secondary education in the districts",
                            operationId = "getSeccondaryPercentage",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Percentage of Secondary education",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    array = @ArraySchema(schema = @Schema(implementation = IncomeResponseModel.class))
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "No data found for Secondary percentage",
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
    public void apiDocumentation() {
        // Método vacío, solo se utiliza para definir la documentación
    }
}