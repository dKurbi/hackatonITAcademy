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
@Table("df_final_1")
public class DistrictDataRecord {
    @Id
    private Integer id;
    @Column("nom_districte")
    private String districtName;
    @Column("renta_media")
    private Double avgIncome;
}

