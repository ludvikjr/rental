package com.unicorn.rental.domain.requestTypes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressRequestType {
    @Schema(example = "Madeup")
    String street;
    @Schema(example = "123")
    int building;
    @Schema(example = "1")
    int cityId;
}
