package com.example.demo.model.dto;

import lombok.Data;

@Data
public class MovieResponseDto {

    private String movieId;

    private String movieName;

    private String language;

    private String genre;

    private String releaseDate;
}
