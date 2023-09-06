package com.example.demo.model.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record MovieResponseDto(@NotNull Integer movieId, @NotBlank String movieName, @NotBlank String genre, @NotBlank String length,
                               @NotBlank String language, @NotBlank String releaseDate) implements Serializable {
}
