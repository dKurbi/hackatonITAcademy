package com.itacademy.hackaton.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseModel {

    private Integer id;
    private String name;
    private Integer valor;
    private Integer colorIndex;

}
