package com.unicorn.rental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    String fullName;
//    List<CarRentalDto> rentals;
    AddressDto address;
}
