package com.example.demo.controller;

import com.example.demo.annotation.AdminOnly;
import com.example.demo.model.dto.MovieScheduleRequestDto;
import com.example.demo.model.dto.ScreenResponseDto;
import com.example.demo.model.dto.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for APIs related to movie schedule upload operation
 */
@RestController
@Validated
@Api(tags = "APIs for uploading movie schedules")
public class MovieUploadController {

    /**
     * API to fetch all the released movies
     *
     * @param authorizationHeader authorizationHeader
     * @return list of movies
     */
    @ApiOperation(value = "API to fetch all the releasing movies")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the movies"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "movies not found")})
    @GetMapping("/admin/movie")
    @AdminOnly
    public /*List<MovieResponseDto>*/ String getMovie(@RequestHeader("Authorization") String authorizationHeader) {

        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        UserDetailsDto userDetailsDto = (UserDetailsDto)authentication.getPrincipal();
        return "Hello, " + userDetailsDto + "! This is a protected resource.";
    }

    /**
     * API to fetch all the screens for the given movie hall to upload movie schedule
     *
     * @param authorizationHeader authorizationHeader
     * @param movieHallId movieHall Id
     * @return list of screens
     */
    @ApiOperation(value = "API to fetch all the screens for the given movie hall to upload movie schedule")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the screens"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "movie hall not found")})
    @GetMapping("/admin/screen/{movieHallId}")
    public List<ScreenResponseDto> getScreen(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("movieHallId") String movieHallId) {
        return null;
    }

    /**
     * API to upload movie schedules
     *
     * @param authorizationHeader authorizationHeader
     * @param movieScheduleRequest movie schedule request
     * @return status
     */
    @ApiOperation(value = "API to upload movie schedules")
    @ApiResponses({@ApiResponse(code = 201, message = "Successfully created the movie schedule"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/movie-upload")
    public ResponseEntity<String> uploadMovieSchedule(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid List<MovieScheduleRequestDto> movieScheduleRequest) {
        return null;
    }
}
