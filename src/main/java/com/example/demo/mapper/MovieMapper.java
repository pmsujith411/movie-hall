package com.example.demo.mapper;

import com.example.demo.model.MovieModel;
import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.dto.response.MovieResponseDto;
import com.example.demo.model.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "status", expression = "java(true)")
    MovieEntity modelToEntity(MovieModel movieModel);

    MovieModel requestDtoToModel(MovieRequestDto movieRequestDto);

    List<MovieModel> entityToModel(List<MovieEntity> movieEntityList);

    List<MovieResponseDto> modelToResponseDto(List<MovieModel> movieModelList);
}
