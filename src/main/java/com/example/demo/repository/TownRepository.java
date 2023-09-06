package com.example.demo.repository;

import com.example.demo.model.dto.response.TownResponseDto;
import com.example.demo.model.entity.TownEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Repository interface for town
 */
@Mapper
public interface TownRepository {

    /**
     * Method to create towns
     *
     * @param townList list of town names
     */
    void createTown(List<TownEntity> townList);

    /**
     * Method to get the towns
     *
     * @return list of towns
     */
    List<TownResponseDto> getTown();
}
