package com.example.demo.repository;

import com.example.demo.model.dto.response.MovieResponseDto;
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
     * @param movieList movieList
     */
    void insertMovie(List<MovieEntity> movieList);

    /**
     * Repository method to fetch movies
     *
     * @return list of movies
     */
    List<MovieResponseDto> getMovie();

    /**
     * Repository method to delete movies
     *
     * @param movieIds movieIds
     */
    void deleteMovie(List<Integer> movieIds);
}
