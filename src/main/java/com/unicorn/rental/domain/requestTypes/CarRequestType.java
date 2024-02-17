package com.unicorn.rental.domain.requestTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarRequestType {
    private String registrationNumber;
    private int colorId;
    private int mileage;
    private int modelId;
}
