package com.unicorn.rental.domain.responseTypes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Message {
    @Schema(example = "<Entity> created/updated/deleted successfully!")
    private String message;
}
