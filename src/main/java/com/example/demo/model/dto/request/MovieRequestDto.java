package com.example.demo.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record MovieRequestDto(@NotBlank String movieName, @NotBlank String genre, @NotBlank String length,
                              @NotBlank String language, @NotNull LocalDate releaseDate) implements Serializable {

    @Serial
    private static final long serialVersionUID = 5461581589116513883L;
}
