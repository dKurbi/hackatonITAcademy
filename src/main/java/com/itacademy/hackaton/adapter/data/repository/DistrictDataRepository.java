package com.itacademy.hackaton.adapter.data.repository;

import com.itacademy.hackaton.adapter.data.entities.DistrictDataRecord;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DistrictDataRepository extends ReactiveCrudRepository<DistrictDataRecord, Integer> {
}
