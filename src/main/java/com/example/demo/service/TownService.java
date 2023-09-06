package com.example.demo.service;

import com.example.demo.model.dto.response.TownResponseDto;

import java.util.List;

public interface TownService {

    /**
     * Method to create towns
     *
     * @param townList list of towns
     */
    void createTown(List<String> townList);

    /**
     * Method to get towns
     *
     * @return list of towns
     */
    List<TownResponseDto> getTown();
}
