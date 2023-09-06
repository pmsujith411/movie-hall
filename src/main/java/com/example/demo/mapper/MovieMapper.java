package com.example.demo.mapper;

import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MovieMapper {

    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "status", expression = "java(true)")
    MovieEntity dtoToEntity(MovieRequestDto movieRecordDto);
}
