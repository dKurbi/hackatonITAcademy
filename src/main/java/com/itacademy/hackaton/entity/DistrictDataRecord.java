package com.itacademy.hackaton.entity;

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

    @Column("addresses_district_name")
    private String districtName;

    @Column("renta_media")
    private Integer avgIncome;

    @Column("num_actividades")
    private Integer numActivities;

    @Column("oferta_educativa")
    private Integer totalEducationalOfferings;

    @Column("infantil")
    private Integer infantSchools;

    @Column("primarias")
    private Integer primarySchools;

    @Column("secundarias")
    private Integer secondarySchools;

}
