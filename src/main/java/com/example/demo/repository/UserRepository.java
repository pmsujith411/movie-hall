package com.example.demo.repository;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Repository for user operations
 */
@Mapper
public interface UserRepository {

    /**
     * Method to search user
     *
     * @param emailId email Id
     * @return role
     */
    String searchUser(@Param("emailId") String emailId);

    /**
     * Method to insert new user
     *
     * @param userEntity userEntity
     * @return number of rows
     */
    int insertUser (@Param("input")UserEntity userEntity);

    /**
     * Method to search role of the user
     *
     * @param userRoleEntity userRoleEntity
     * @return role
     */
    int insertRole(@Param("input")UserRoleEntity userRoleEntity);
}
