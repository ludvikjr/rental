package com.unicorn.rental.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @Schema(example = "John Doe")
    String fullName;
    List<CarRentalDto> rentals;
    AddressDto address;
}
