package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class MovieEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5461581589116513883L;

    private Integer movieId;

    private String movieName;

    private String genre;

    private String length;

    private String language;

    private LocalDate releaseDate;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
