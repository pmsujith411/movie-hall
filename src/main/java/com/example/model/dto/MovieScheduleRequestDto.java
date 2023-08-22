package com.example.model.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
