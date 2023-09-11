package com.example.demo.mapper;

import com.example.demo.model.MovieHallModel;
import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.dto.response.MovieHallResponseDto;
import com.example.demo.model.entity.MovieHallEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MovieHallMapper {
    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "status", expression = "java(true)")
    MovieHallEntity modelToEntity(MovieHallModel movieHallModel);

    MovieHallModel requestDtoToModel(MovieHallRequestDto movieHallRequestDto, String townId);

    List<MovieHallModel> entityToModel(List<MovieHallEntity> movieHallEntityList);

    List<MovieHallResponseDto> modelToResponseDto(List<MovieHallModel> movieHallModelList);
}
