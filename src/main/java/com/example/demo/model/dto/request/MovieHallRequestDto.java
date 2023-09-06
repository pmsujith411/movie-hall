package com.example.demo.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * record for movie hall request dto
 */
public record MovieHallRequestDto(@NotBlank String hallName, @NotNull Integer townId) implements Serializable {
}
