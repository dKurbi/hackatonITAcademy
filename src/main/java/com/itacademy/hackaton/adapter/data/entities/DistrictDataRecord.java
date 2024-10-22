package com.itacademy.hackaton.adapter.data.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("districts")
public class DistrictDataRecord {

    @Id
    private Integer id;

    @Column("nom_districte")
    private String districtName;

    @Column("renta_media")
    private Double avgIncome;

    @Column("num_activitades")
    private Double avgNumActivities;

}

