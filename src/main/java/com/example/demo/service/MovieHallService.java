package com.example.demo.service;

import com.example.demo.model.MovieHallModel;

import java.util.List;

/**
 * Interface for movie hall service
 */
public interface MovieHallService {

    /**
     * Service method to create movie halls
     *
     * @param movieHallModelList list of movie halls
     */
    void createMovieHall(MovieHallModel movieHallModelList);

    /**
     * service method to fetch all movie halls for the given town
     * @param townId townId
     * @return list of movie halls
     */
    List<MovieHallModel> getMovieHall(Integer townId);
}
