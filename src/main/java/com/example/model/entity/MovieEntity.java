package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieEntity implements Serializable {

    private static final long serialVersionUID = 5461581589116513883L;

    private String movieId;

    private String movieName;

    private String genre;

    private Integer length;

    private String language;

    private OffsetDateTime releaseDate;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
