package com.unicorn.rental.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto implements Serializable {
    private int id;
    private String registrationNumber;
    private String color;
    private int mileage;
    private String model;
    private String brand;
}
