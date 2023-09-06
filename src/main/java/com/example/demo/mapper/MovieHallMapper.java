package com.example.demo.mapper;

import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.entity.MovieHallEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MovieHallMapper {
    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "status", expression = "java(true)")
    MovieHallEntity dtoToEntity(MovieHallRequestDto movieHallRequestDto);
}
