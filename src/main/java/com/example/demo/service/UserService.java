package com.example.demo.service;

import com.example.demo.model.CustomOAuth2User;

/**
 * Interface for user services
 */
public interface UserService {

    /**
     * Service method to search and create user if needed
     *
     * @param customOAuth2User customOAuth2User
     * @return customOAuth2User
     */
    CustomOAuth2User searchAndInsertUser(final CustomOAuth2User customOAuth2User);
}
