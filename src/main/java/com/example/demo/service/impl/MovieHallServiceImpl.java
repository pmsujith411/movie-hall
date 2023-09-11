package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.MovieHallMapper;
import com.example.demo.model.MovieHallModel;
import com.example.demo.model.entity.MovieHallEntity;
import com.example.demo.repository.MovieHallRepository;
import com.example.demo.service.MovieHallService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Log4j2
public class MovieHallServiceImpl implements MovieHallService {

    @Autowired
    private MovieHallRepository repository;

    @Autowired
    private MovieHallMapper mapper;

    @Override
    public void createMovieHall(MovieHallModel movieHallModel) {

        repository.createMovieHall(mapper.modelToEntity(movieHallModel));
    }

    @Override
    public List<MovieHallModel> getMovieHall(Integer townId) {

        List<MovieHallEntity> movieHallEntityList = repository.getMovieHall(townId);

        if (CollectionUtils.isEmpty(movieHallEntityList)) {
            log.error("Unable to fetch the movie halls for the given town. townId {}", townId);

            throw new ResourceNotFoundException("Unable to fetch the movie halls");
        }

        return mapper.entityToModel(movieHallEntityList);
    }
}
