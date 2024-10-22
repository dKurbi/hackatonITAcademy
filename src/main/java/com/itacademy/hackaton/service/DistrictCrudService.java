package com.itacademy.hackaton.service;

import com.itacademy.hackaton.entity.IncomeResponseModel;
import com.itacademy.hackaton.entity.DistrictDataRecord;
import com.itacademy.hackaton.entity.InstitutionsResponseModel;
import com.itacademy.hackaton.repository.DistrictDataRepository;
import com.itacademy.hackaton.exception.DistrictRetrievalException;
import com.itacademy.hackaton.exception.NoDistrictFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.Comparator;

import static java.lang.Math.toIntExact;
import static reactor.core.publisher.Flux.error;
import static reactor.core.publisher.Flux.fromIterable;

@Service
@RequiredArgsConstructor
public final class DistrictCrudService {

    private final DistrictDataRepository districtDataRepository;

    public static final String AN_EMPTY_FLUX = "The repository returned an empty flux.";


    public Flux<IncomeResponseModel> getAllDistricts() {

        return districtDataRepository.findAll()

                .switchIfEmpty(error(new NoDistrictFoundException(AN_EMPTY_FLUX)))

                .map(DistrictCrudService::mapToIncomeResponseModel)

                .sort(Comparator.comparingDouble(IncomeResponseModel::getValor))

                .index()

                .map(DistrictCrudService::addColorValueToRecord)

                .onErrorMap(e -> new DistrictRetrievalException(e.getMessage()));

    }

    public Flux<InstitutionsResponseModel> getInfantilPercentage() {

        return districtDataRepository.findAll()

                .collectList()

                .flatMapMany(districtList -> {

                    if (districtList.isEmpty())
                        return error(new NoDistrictFoundException(AN_EMPTY_FLUX));

                    int totalInfantil = districtList.stream()
                            .mapToInt(DistrictDataRecord::getInfantSchools)
                            .sum();

                    return fromIterable(districtList)
                            .map(district -> mapToInstitutionsResponseModel(district, totalInfantil)); // Your existing method

                })

                .onErrorMap(e -> new DistrictRetrievalException(e.getMessage()));
    }

    public Flux<InstitutionsResponseModel> getPrimaryPercentage() {

        return districtDataRepository.findAll()

                .collectList()

                .flatMapMany(districtList -> {

                    if (districtList.isEmpty())
                        return error(new NoDistrictFoundException(AN_EMPTY_FLUX));

                    int totalPrimary = districtList.stream()
                            .mapToInt(DistrictDataRecord::getPrimarySchools)
                            .sum();

                    return fromIterable(districtList)
                            .map(district -> mapToInstitutionsResponseModel(district, totalPrimary));

                })

                .onErrorMap(e -> new DistrictRetrievalException(e.getMessage()));
    }

    private static InstitutionsResponseModel mapToInstitutionsResponseModel(DistrictDataRecord district, int totalInfantil) {
        double percentage = ((double) district.getInfantSchools() / totalInfantil) * 100;


        return new InstitutionsResponseModel(
                district.getId(),
                district.getDistrictName(),
                district.getPrimarySchools(),
                percentage
        );
    }

    private static IncomeResponseModel addColorValueToRecord(Tuple2<Long, IncomeResponseModel> recordTuple) {

        IncomeResponseModel incomeResponseModel = recordTuple.getT2();

        incomeResponseModel.setColorIndex(toIntExact(recordTuple.getT1()));

        return incomeResponseModel;

    }

    private static InstitutionsResponseModel addRadiusToRecord(Tuple2<Long, InstitutionsResponseModel> recordTuple) {

        InstitutionsResponseModel institutionsResponseModel = recordTuple.getT2();

        institutionsResponseModel.setPercentage(Double.valueOf(recordTuple.getT1()));

        return institutionsResponseModel;

    }

    private static IncomeResponseModel mapToIncomeResponseModel(DistrictDataRecord record) {

        return new IncomeResponseModel(
                record.getId(),
                record.getDistrictName(),
                record.getAvgIncome(),
                null
        );

    }

}
