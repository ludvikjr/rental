package com.unicorn.rental.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    @Schema(example = "Madeup")
    String street;
    @Schema(example = "123")
    int building;
    @Schema(example = "Prague")
    String city;
    @Schema(example = "Prague")
    String region;
    @Schema(example = "Czech republic")
    String country;
    @Schema(example = "11010")
    String postalCode;
}
