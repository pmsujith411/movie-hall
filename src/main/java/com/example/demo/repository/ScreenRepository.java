package com.example.demo.repository;

import com.example.demo.model.entity.ScreenEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Repository for screen related services
 */
@Mapper
public interface ScreenRepository {

    /**
     * Repository method to create screen
     *
     * @param list list of screens
     */
    void createScreen(List<ScreenEntity> list);

    /**
     * Repository method to fetch screens
     *
     * @param hallId hallId
     * @return list of screens
     */
    List<ScreenEntity> getScreen(Integer hallId);
}
