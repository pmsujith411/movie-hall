package com.example.demo.service.impl;

import com.example.demo.mapper.ScreenMapper;
import com.example.demo.model.dto.request.ScreenRequestDto;
import com.example.demo.model.dto.response.ScreenResponseDto;
import com.example.demo.model.entity.ScreenEntity;
import com.example.demo.repository.ScreenRepository;
import com.example.demo.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for screen
 */
@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private ScreenRepository repository;

    @Autowired
    private ScreenMapper screenMapper;

    @Override
    public void createScreen(List<ScreenRequestDto> screenRequestDtoList) {
        List<ScreenEntity> screenEntityList = screenRequestDtoList
                .stream()
                .map(screenMapper::dtoToEntity)
                .toList();

        repository.createScreen(screenEntityList);
    }

    @Override
    public List<ScreenResponseDto> getScreen(Integer hallId) {

        List<ScreenEntity> screenEntityList = repository.getScreen(hallId);

        return screenEntityList
                .stream()
                .map(screenMapper::entityToDto)
                .toList();
    }
}
