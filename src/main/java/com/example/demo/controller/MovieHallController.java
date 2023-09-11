package com.example.demo.controller;

import com.example.demo.mapper.MovieHallMapper;
import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.dto.response.MovieHallResponseDto;
import com.example.demo.service.MovieHallService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * Controller for APIs related to movie hall related operation
 */
@Tag(name = "Movie", description = "APIs for movie hall related services")
@RequestMapping("/movie-hall")
@Validated
@RestController
public class MovieHallController {

    @Autowired
    private MovieHallService movieHallService;

    @Autowired
    private MovieHallMapper mapper;

    /**
     * API to create movie halls
     *
     * @param townId townId
     * @param authorizationHeader authorizationHeader
     * @param movieHallRequestDto movieHallRequestDto
     */
    @Operation(description = "API to create movie halls")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @PostMapping("/{townId}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void createMovieHall(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid MovieHallRequestDto movieHallRequestDto,
            @PathVariable("townId") @NotBlank String townId) {
        movieHallService.createMovieHall(mapper.requestDtoToModel(movieHallRequestDto, townId));
    }

    /**
     * API to fetch all movie halls for the given town
     *
     * @param authorizationHeader authorizationHeader
     * @param townId town Id
     * @return list of movie halls
     */
    @Operation(description = "API to fetch all movie halls for the given town")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the movie halls"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "movie hall not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("/{townId}")
    public List<MovieHallResponseDto> getMovieHall(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("townId") @NotNull Integer townId) {
        return mapper.modelToResponseDto(movieHallService.getMovieHall(townId));
    }
}
