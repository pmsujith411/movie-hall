package com.example.demo.model.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * record for screen request dto
 */
public record ScreenRequestDto(@NotNull Integer screenNumber, @NotNull Integer hallId, @NotNull Integer seatCount)
        implements Serializable {
}
