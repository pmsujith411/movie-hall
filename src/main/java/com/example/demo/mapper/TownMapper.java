package com.example.demo.mapper;

import com.example.demo.model.TownModel;
import com.example.demo.model.dto.response.TownResponseDto;
import com.example.demo.model.entity.TownEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for town
 */
@Mapper
public interface TownMapper {

    TownModel entityToModel(TownEntity townEntity);

    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    TownEntity modelToEntity(TownModel townModel);

    List<TownResponseDto> modelToResponseDto(List<TownModel> townModelList);

    List<TownModel> entityToModel(List<TownEntity> townEntityList);

    TownModel requestToModel(String townName);
}
