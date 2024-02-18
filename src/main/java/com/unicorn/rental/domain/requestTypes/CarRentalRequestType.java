package com.unicorn.rental.domain.requestTypes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarRentalRequestType {
    @Schema(example = "1")
    private int carId;

    @Schema(example = "1")
    private int userId;

    private Date rentedTo;

    private Date rentedFrom;
}
