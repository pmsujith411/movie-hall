package com.example.demo.repository;

import com.example.demo.model.entity.MovieEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Repository for movie upload services
 */
@Mapper
public interface MovieRepository {

    /**
     * Repository method to insert movies
     *
     * @param movieEntity movieEntity
     */
    void insertMovie(MovieEntity movieEntity);

    /**
     * Repository method to fetch movies
     *
     * @return list of movies
     */
    List<MovieEntity> getMovie();

    /**
     * Repository method to delete movies
     *
     * @param movieIds movieIds
     */
    void deleteMovie(List<Integer> movieIds);
}
