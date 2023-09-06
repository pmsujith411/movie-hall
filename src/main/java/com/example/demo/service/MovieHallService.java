package com.example.demo.service;

import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.dto.response.MovieHallResponseDto;

import java.util.List;

/**
 * Interface for movie hall service
 */
public interface MovieHallService {

    /**
     * Service method to create movie halls
     *
     * @param movieHallRequestDtoList list of movie halls
     */
    void createMovieHall(List<MovieHallRequestDto> movieHallRequestDtoList);

    /**
     * service method to fetch all movie halls for the given town
     * @param townId townId
     * @return list of movie halls
     */
    List<MovieHallResponseDto> getMovieHall(Integer townId);
}
