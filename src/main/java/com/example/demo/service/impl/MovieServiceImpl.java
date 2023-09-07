package com.example.demo.service.impl;

import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.dto.response.MovieResponseDto;
import com.example.demo.model.entity.MovieEntity;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for movie upload service
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void insertMovie(final List<MovieRequestDto> movieRecordDtoList) {

        List<MovieEntity> movieEntityList = movieRecordDtoList
                .stream()
                .map(movieMapper::dtoToEntity)
                .toList();

        movieRepository.insertMovie(movieEntityList);
    }

    @Override
    public List<MovieResponseDto> getMovie() {
        return movieRepository.getMovie();
    }

    @Override
    public void deleteMovie(List<Integer> movieIds) {
        movieRepository.deleteMovie(movieIds);
    }
}
