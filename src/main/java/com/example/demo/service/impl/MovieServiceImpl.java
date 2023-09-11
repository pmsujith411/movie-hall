package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.MovieModel;
import com.example.demo.model.entity.MovieEntity;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Service implementation for movie upload service
 */
@Service
@Log4j2
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void insertMovie(final MovieModel movieModel) {

        MovieEntity movieEntity = movieMapper.modelToEntity(movieModel);

        movieRepository.insertMovie(movieEntity);
    }

    @Override
    public List<MovieModel> getMovie() {

        List<MovieEntity> movieEntityList = movieRepository.getMovie();

        if (CollectionUtils.isEmpty(movieEntityList)) {
            log.error("Unable to fetch the movies");

            throw new ResourceNotFoundException("Unable to fetch the movies");
        }

        return movieMapper.entityToModel(movieEntityList);
    }

    @Override
    public void deleteMovie(List<Integer> movieIds) {
        movieRepository.deleteMovie(movieIds);
    }
}
