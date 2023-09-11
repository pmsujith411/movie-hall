package com.example.demo.service;

import com.example.demo.model.dto.request.ScreenRequestDto;
import com.example.demo.model.dto.response.ScreenResponseDto;

import java.util.List;

/**
 * Interface for screen service
 */
public interface ScreenService {

    /**
     * service method to create screen
     *
     * @param screenRequestDtoList list of screens
     */
    void createScreen(List<ScreenRequestDto> screenRequestDtoList);

    /**
     * service method to fetch screens
     *
     * @param hallId hallId
     * @return list of screens
     */
    List<ScreenResponseDto> getScreen(Integer hallId);
}
