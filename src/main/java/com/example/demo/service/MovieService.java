package com.example.demo.service;

import com.example.demo.model.MovieModel;

import java.util.List;

/**
 * Interface for movie service
 */
public interface MovieService {

    /**
     * Service method to insert movies
     *
     * @param movieModel movieModel
     */
    void insertMovie(final MovieModel movieModel);

    /**
     * Service method to fetch movies
     *
     * @return list of movies
     */
    List<MovieModel> getMovie();

    /**
     * Service method delete movies
     *
     * @param movieIds movieIds
     */
    void deleteMovie(List<Integer> movieIds);
}
