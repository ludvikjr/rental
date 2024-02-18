package com.unicorn.rental.domain.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto implements Serializable {
    @Schema(example = "1")
    private int id;

    @Schema(example = "4AC6812")
    private String registrationNumber;

    @Schema(example = "Silver")
    private String color;

    @Schema(example = "150000")
    private int mileage;

    @Schema(example = "e39")
    private String model;

    @Schema(example = "BMW")
    private String brand;
}
