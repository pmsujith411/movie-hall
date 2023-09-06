package com.example.demo.service.impl;

import com.example.demo.mapper.MovieHallMapper;
import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.dto.response.MovieHallResponseDto;
import com.example.demo.model.entity.MovieHallEntity;
import com.example.demo.repository.MovieHallRepository;
import com.example.demo.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallServiceImpl implements MovieHallService {

    @Autowired
    private MovieHallRepository repository;

    @Autowired
    private MovieHallMapper movieHallMapper;

    @Override
    public void createMovieHall(List<MovieHallRequestDto> movieHallRequestDtoList) {

        List<MovieHallEntity> movieHallEntityList = movieHallRequestDtoList.stream().map(movieHallMapper::dtoToEntity).toList();

        repository.createMovieHall(movieHallEntityList);
    }

    @Override
    public List<MovieHallResponseDto> getMovieHall(Integer townId) {
        return repository.getMovieHall(townId);
    }
}
