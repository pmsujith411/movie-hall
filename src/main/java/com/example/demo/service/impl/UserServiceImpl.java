package com.example.demo.service.impl;

import com.example.demo.enumeration.Roles;
import com.example.demo.exception.DataBaseUpsertException;
import com.example.demo.model.CustomOAuth2User;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.entity.UserRoleEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;

/**
 * Implementation class for user services
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomOAuth2User searchAndInsertUser(final CustomOAuth2User customOAuth2User) {

        CustomOAuth2User customOAuth2UserResponse = new CustomOAuth2User();

        BeanUtils.copyProperties(customOAuth2User, customOAuth2UserResponse);

        String role = userRepository.searchUser(customOAuth2User.getEmailId());

        if (StringUtils.isEmpty(role)) {

            log.info("Creating new user");

            UserEntity userEntity = new UserEntity();

            BeanUtils.copyProperties(customOAuth2User, userEntity);

            userEntity.setStatus(Boolean.TRUE);
            userEntity.setCreatedOn(OffsetDateTime.now());
            userEntity.setUpdatedOn(OffsetDateTime.now());

            int count = userRepository.insertUser(userEntity);

            if (count > 0) {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                userRoleEntity.setUserId(userEntity.getUserId());
                userRoleEntity.setRole(Roles.USER.getValue());
                userRoleEntity.setCreatedOn(OffsetDateTime.now());
                userRoleEntity.setUpdatedOn(OffsetDateTime.now());

                userRepository.insertRole(userRoleEntity);

                role = Roles.USER.getValue();

                log.info("Successfully created new user and assigned role");
            } else {
                log.error("Error while creating new user");

                throw new DataBaseUpsertException("Error while creating new user");
            }
        }

        customOAuth2UserResponse.setRole(role);

        return customOAuth2UserResponse;
    }
}
