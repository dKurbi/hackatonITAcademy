package com.itacademy.hackaton.adapter.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("sample_datos")
public class DistrictDataRecord {

    @Id
    private Integer districtId;
    private Integer recordYear;
    private String equipment;
    private String indicator;
    private Double value;
    private String dataNotes;
    private String dataEquipment;
    private String ownership;
    private String generalType;
    private String equipmentType;
    private String scope;
    private Double latitude;
    private Double longitude;
    private String districtName;
    private Integer neighborhoodCode;
    private String neighborhoodName;
    private Integer grossIncomeByNeighborhood;
    private Integer grossIncomeByDistrict;

}

