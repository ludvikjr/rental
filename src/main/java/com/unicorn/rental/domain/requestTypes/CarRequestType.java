package com.unicorn.rental.domain.requestTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRequestType {
    private String registrationNumber;
    private int colorId;
    private int mileage;
    private int modelId;
}
