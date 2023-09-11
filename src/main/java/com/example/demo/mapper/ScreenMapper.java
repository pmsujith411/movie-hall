package com.example.demo.mapper;

import com.example.demo.model.dto.request.ScreenRequestDto;
import com.example.demo.model.dto.response.ScreenResponseDto;
import com.example.demo.model.entity.ScreenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for dto and entity classes
 */
@Mapper
public interface ScreenMapper {

    @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
    @Mapping(target = "status", expression = "java(true)")
    ScreenEntity dtoToEntity(ScreenRequestDto screenRequestDto);

    ScreenResponseDto entityToDto(ScreenEntity screenEntity);
}
