package com.example.demo.service.impl;

import com.example.demo.enumeration.Roles;
import com.example.demo.exception.DataBaseUpsertException;
import com.example.demo.model.CustomOAuth2User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

/**
 * Test class for UserServiceImpl
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private CustomOAuth2User customOAuth2User;

    private CustomOAuth2User customOAuth2UserResponse;

    private Map<String, Object> attributes;

    /**
     * Test case to test method searchAndInsertUser with existing user
     */
    @Test
    public void testExistingUser() {

        attributes = new HashMap<>();
        attributes.put("email", "mockEmail");
        customOAuth2User = new CustomOAuth2User(attributes);

        when(userRepository.searchUser(anyString())).thenReturn(Roles.USER.getValue());
        customOAuth2UserResponse = userService.searchAndInsertUser(customOAuth2User);

        assertEquals(Roles.USER.getValue(), customOAuth2UserResponse.getRole());
    }

    /**
     * Test case to test searchAndInsertUser method with new user success case
     */
    @Test
    public void testNewUser_Success() {

        attributes = new HashMap<>();
        attributes.put("email", "mockEmail");
        attributes.put("name", "mockName");
        customOAuth2User = new CustomOAuth2User(attributes);

        when(userRepository.insertUser(any())).thenReturn(1);

        customOAuth2UserResponse = userService.searchAndInsertUser(customOAuth2User);

        assertEquals(Roles.USER.getValue(), customOAuth2UserResponse.getRole());
    }

    /**
     * Test case to test searchAndInsertUser method with new user error case
     */
    @Test
    public void testNewUser_Error() {

        attributes = new HashMap<>();
        attributes.put("email", "mockEmail");
        attributes.put("name", "mockName");
        customOAuth2User = new CustomOAuth2User(attributes);

        Throwable throwable =
                assertThrows(DataBaseUpsertException.class, () -> userService.searchAndInsertUser(customOAuth2User));

        assertEquals("Error while creating new user", throwable.getMessage());
    }
}
