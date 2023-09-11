package com.example.demo.repository;

import com.example.demo.model.entity.MovieHallEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieHallRepository {

    /**
     * Repository method to create movie halls
     *
     * @param movieHallEntity movieHallEntity
     */
    void createMovieHall(MovieHallEntity movieHallEntity);

    /**
     * Repository method to fetch movie halls for the given town
     *
     * @param townId townId
     * @return list of movie halls
     */
    List<MovieHallEntity> getMovieHall(Integer townId);
}
