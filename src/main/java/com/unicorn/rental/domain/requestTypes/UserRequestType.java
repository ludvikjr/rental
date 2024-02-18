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
public class UserRequestType {
    @Schema(example = "John Doe")
    String fullName;
    AddressRequestType address;
}
