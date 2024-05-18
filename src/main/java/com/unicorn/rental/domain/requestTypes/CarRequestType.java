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
public class CarRequestType {
    @Schema(example = "4AC6812")
    private String registrationNumber;
    @Schema(example = "1")
    private int colorId;
    @Schema(example = "150000")
    private int mileage;
    @Schema(example = "1")
    private int modelId;
}
