package com.example.demo.service.impl;

import com.example.demo.model.dto.response.TownResponseDto;
import com.example.demo.model.entity.TownEntity;
import com.example.demo.repository.TownRepository;
import com.example.demo.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * implementation for town service
 */
@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository repository;

    @Override
    public void createTown(List<String> townList) {

        List<TownEntity> townEntityList = townList
                .stream()
                .map(town -> TownEntity
                        .builder()
                        .townName(town)
                        .createdOn(OffsetDateTime.now())
                        .updatedOn(OffsetDateTime.now())
                        .build())
                .toList();

        repository.createTown(townEntityList);
    }

    @Override
    public List<TownResponseDto> getTown() {
        return repository.getTown();
    }
}
