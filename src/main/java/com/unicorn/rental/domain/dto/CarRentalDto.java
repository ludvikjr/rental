package com.unicorn.rental.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
