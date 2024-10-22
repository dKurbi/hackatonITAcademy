package com.itacademy.hackaton.application.port.in;

import com.itacademy.hackaton.adapter.controllers.IncomeResponseModel;
import com.itacademy.hackaton.adapter.data.entities.DistrictDataRecord;
import com.itacademy.hackaton.adapter.data.repository.DistrictDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public final class DistrictCrudService {


    private final DistrictDataRepository districtDataRepository;

    public Flux<IncomeResponseModel> getAllDistricts() {

        return districtDataRepository.findAll()

                .doOnNext(System.err::println)

                // Filter to get only the ones whose value collectd the number of activities in the center
                .filter(record -> filterByIndicator(record, "ActivitatsDeFormacio"))

                .map(DistrictCrudService::mapToIncomeResponseModel);

    }

    private static boolean filterByIndicator(DistrictDataRecord record, String indicatorName) {
        return Objects.equals(record.getIndicator(), indicatorName);
    }

    private static IncomeResponseModel mapToIncomeResponseModel(DistrictDataRecord record) {

        return new IncomeResponseModel(
                record.getDistrictName(),
                record.getDistrictId(),
                record.getValue(),
                null
        );

    }

}
