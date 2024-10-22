package com.itacademy.hackaton.adapter.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("sample_datos")
public class DistrictDataRecord {

    @Id
    @Column("district_id")
    private Integer id;
    @Column("district_name")
    private String nom_districte;
    @Column("neighborhood_name")
    private String nom_barri;
    @Column("neighborhood_code")
    private String codi_barri;
    @Column("neighborhood_rent_mean")
    private String renta_barri_mean;
    @Column("district_rent_mean")
    private String renta_distrito_mean;

}

