package com.example.demo.service;

import com.example.demo.model.TownModel;

import java.util.List;

public interface TownService {

    /**
     * Method to create towns
     *
     * @param townModel town model
     */
    void createTown(TownModel townModel);

    /**
     * Method to get towns
     *
     * @return list of towns
     */
    List<TownModel> getTown();
}
