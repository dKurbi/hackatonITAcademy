package com.itacademy.hackaton.controller;

import com.itacademy.hackaton.entity.IncomeResponseModel;
import com.itacademy.hackaton.service.DistrictCrudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DistrictControllerTest {

    @Mock
    private DistrictCrudService districtCrudService;

    @InjectMocks
    private DistrictController districtController;

    private WebTestClient webTestClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        webTestClient = WebTestClient.bindToRouterFunction(districtController.districtRouteFunctions()).build();
    }

    @Test
    public void testGetAllDistrictsSuccess() {
        IncomeResponseModel district1 = new IncomeResponseModel(1, "Eixample", 30000.0, 1);
        IncomeResponseModel district2 = new IncomeResponseModel(2, "Ciutat Vella", 25000.0, 2);

        List<IncomeResponseModel> mockDistricts = Arrays.asList(district1, district2);
        when(districtCrudService.getAllDistricts()).thenReturn(Flux.fromIterable(mockDistricts));

        webTestClient.get()
                .uri("/api/districts/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("application/json")
                .expectBodyList(IncomeResponseModel.class)
                .hasSize(2)
                .contains(district1, district2);

    }

    @Test
    public void testGetAllDistrictsNotFound() {
        when(districtCrudService.getAllDistricts()).thenReturn(Flux.empty());
        webTestClient.get()
                .uri("/api/districts/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(IncomeResponseModel.class)
                .hasSize(0);
    }

    @Test
    public void testGetAllDistrictsInternalError() {
        when(districtCrudService.getAllDistricts()).thenReturn(Flux.error(new RuntimeException("Internal error")));
        webTestClient.get()
                .uri("/api/districts/")
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
