package com.example.demo.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieScheduleRequestDto implements Serializable {

    private static final long serialVersionUID = -4076682688993460842L;

    @NotBlank
    private String movieId;

    @NotBlank
    private String screenId;

    @NotBlank
    private String showTime;

    @Future
    @NotNull
    private OffsetDateTime fromDate;

    @Future
    @NotNull
    private OffsetDateTime toDate;
}
