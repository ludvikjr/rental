package com.unicorn.rental.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    String street;
    int building;
    String city;
    String region;
    String country;
    String postalCode;
}
