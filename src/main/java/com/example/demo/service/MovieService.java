package com.example.demo.service;

import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.dto.response.MovieResponseDto;

import java.util.List;

/**
 * Interface for movie service
 */
public interface MovieService {

    /**
     * Service method to insert movies
     *
     * @param movieRecordDtoList movieRecordDtoList
     */
    void insertMovie(final List<MovieRequestDto> movieRecordDtoList);

    /**
     * Service method to fetch movies
     *
     * @return list of movies
     */
    List<MovieResponseDto> getMovie();

    /**
     * Service method delete movies
     *
     * @param movieIds movieIds
     */
    void deleteMovie(List<Integer> movieIds);
}
