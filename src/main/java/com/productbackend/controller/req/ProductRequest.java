package com.productbackend.controller.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "Title is mandatory")
        @Size(min = 5, max = 25, message = "Title must be between 5 and 25 characters")
        String title,

        @Positive(message = "Price is mandatory")
        BigDecimal price
) {
}