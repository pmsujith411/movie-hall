package com.example.demo.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * Model for movie
 */
@Data
public class MovieModel {

    private Integer movieId;

    private String movieName;

    private String genre;

    private String length;

    private String language;

    private LocalDate releaseDate;
}
