package com.example.demo.model.dto.response;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * record for screen request dto
 */
public record ScreenResponseDto(Integer screenId, Integer screenNumber, Integer hallId, Integer seatCount)
        implements Serializable {
}
