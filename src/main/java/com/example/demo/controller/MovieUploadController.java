package com.example.demo.controller;

import com.example.demo.model.dto.MovieScheduleRequestDto;
import com.example.demo.model.dto.ScreenResponseDto;
import com.example.demo.model.dto.UserDetailsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for APIs related to movie schedule upload operation
 */
@RestController
@Validated
@Tag(name = "MovieUpload", description = "APIs for uploading movie schedules")
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class MovieUploadController {

    /**
     * API to fetch all the released movies
     *
     * @param authorizationHeader authorizationHeader
     * @return list of movies
     */
    @Operation(summary = "API to fetch all the releasing movies")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the movies"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "movies not found")})
    @GetMapping("/movie")
    public /*List<MovieResponseDto>*/ String getMovie(@RequestHeader("Authorization") String authorizationHeader) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
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
    @Operation(summary = "API to fetch all the screens for the given movie hall to upload movie schedule")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the screens"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "movie hall not found")})
    @GetMapping("/screen/{movieHallId}")
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
    @Operation(summary = "API to upload movie schedules")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Successfully created the movie schedule"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movie-upload")
    public ResponseEntity<String> uploadMovieSchedule(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid List<MovieScheduleRequestDto> movieScheduleRequest) {
        return null;
    }
}
