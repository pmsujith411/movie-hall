package com.example.demo.util;

import com.example.demo.model.CustomOAuth2User;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Test class for JwtUtil
 */
@RunWith(SpringRunner.class)
public class JwtUtilTest {

    @InjectMocks
    private JwtUtil jwtUtil;

    private String token;

    @Before
    public void setUp() {
        token = "eyJhbGciOiJIUzI1NiJ9"
                +
                ".eyJyb2xlIjoidXNlciIsImVtYWlsSWQiOiJwbS5zdWppdGg0MUBnbWFpbC5jb20iLCJ1c2VyTmFtZSI6IlN1aml0aCBQLk0iLCJleHAiOjE2OTMzOTk5NDQsImlhdCI6MTY5MzM2Mzk0NH0.jrRtvAR2f8g9q1NUnjkmhZa3xLzT464M_QFQpdFQxTk";
    }

    /**
     * Test case to test expired token
     */
    @Test(expected = ExpiredJwtException.class)
    public void testExpiredToken() {

        jwtUtil.extractUser(token);
    }

    /**
     * Test case to test method generateToken with success case
     */
    @Test
    public void testGenerateToken() {
        Map<String, Object> attributes = new HashMap<>();
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(attributes);

        attributes.put("email", "mockEmail");
        attributes.put("name", "mockName");

        assertNotNull(jwtUtil.generateToken(customOAuth2User));
    }

    /**
     * Test case to test validateToken method with success response
     */
    @Test
    public void testValidateToken() {
        assertNotNull(jwtUtil.validateToken(token));
    }
}
