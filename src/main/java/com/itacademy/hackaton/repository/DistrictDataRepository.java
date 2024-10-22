package com.itacademy.hackaton.repository;

import com.itacademy.hackaton.entity.DistrictDataRecord;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DistrictDataRepository extends ReactiveCrudRepository<DistrictDataRecord, Integer> {
}
