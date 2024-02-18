package com.unicorn.rental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRentalDto {
    Date rentedFrom;
    Date rentedTo;
    CarDto car;
}
