package com.example.demo.controller;

import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.dto.MovieScheduleRequestDto;
import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.dto.response.MovieResponseDto;
import com.example.demo.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for APIs related to movie related operation
 */
@Tag(name = "Movie", description = "APIs for movie related services")
@RequestMapping("/movie")
@Validated
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper mapper;

    /**
     * API to fetch all the released movies
     *
     * @param authorizationHeader authorizationHeader
     * @return list of movies
     */
    @Operation(summary = "API to fetch all the releasing movies")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the movies"),
            @ApiResponse(responseCode = "404", description = "movies not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping
    public List<MovieResponseDto> getMovie(@RequestHeader("Authorization") String authorizationHeader) {
        return mapper.modelToResponseDto(movieService.getMovie());
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> uploadMovieSchedule(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid List<MovieScheduleRequestDto> movieScheduleRequest) {
        return null;
    }

    /**
     * API to insert movies
     *
     * @param authorizationHeader authorizationHeader
     * @param movieRequestDto movieRequestDto
     */
    @Operation(summary = "API to insert movies")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void insertMovie(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid MovieRequestDto movieRequestDto) {

        movieService.insertMovie(mapper.requestDtoToModel(movieRequestDto));
    }

    /**
     * API to delete movies
     *
     * @param authorizationHeader authorizationHeader
     * @param movieIds movieIds
     */
    @Operation(summary = "API to delete movies")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMovie(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @NotNull List<@NotNull Integer> movieIds) {
        movieService.deleteMovie(movieIds);
    }
}
