package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TownMapper;
import com.example.demo.model.TownModel;
import com.example.demo.model.entity.TownEntity;
import com.example.demo.repository.TownRepository;
import com.example.demo.service.TownService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * implementation for town service
 */
@Service
@Log4j2
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository repository;

    @Autowired
    private TownMapper mapper;

    @Override
    public void createTown(TownModel townModel) {

        TownEntity townEntity = mapper.modelToEntity(townModel);

        repository.createTown(townEntity);
    }

    @Override
    public List<TownModel> getTown() {

        List<TownEntity> townEntityList = repository.getTown();

        if (CollectionUtils.isEmpty(townEntityList)) {

            log.error("No records for towns");

            throw new ResourceNotFoundException("No records for towns");
        }

        return mapper.entityToModel(townEntityList);
    }
}
