package com.example.demo.controller;

import com.example.demo.model.CustomOAuth2User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for user authentication
 */
@RestController
@Log4j2
@Api(tags = "Redirect API for user authentication")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    /**
     * API to generate jwt token
     *
     * @param oauth2User oauth2User
     * @return token
     */
    @ApiOperation(value = "API to generate jwt token for user authentication")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully generated the token"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/authenticate")
    public ResponseEntity<String> getUserDetails(@AuthenticationPrincipal OAuth2User oauth2User) {

        CustomOAuth2User customOAuth2User = new CustomOAuth2User(oauth2User.getAttributes());

        CustomOAuth2User customOAuth2UserResponse = userService.searchAndInsertUser(customOAuth2User);

        return ResponseEntity.ok(jwtUtil.generateToken(customOAuth2UserResponse));
    }
}
