package com.example.demo.controller;

import com.example.model.dto.MovieResponseDto;
import com.example.model.dto.MovieScheduleRequestDto;
import com.example.model.dto.ScreenResponseDto;
import com.example.model.dto.TicketReportResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for MovieHall application admin APIs
 */
@RestController
@Validated
@Api(tags = "Admin APIs for managing movie halls")
public class MovieHallAdminController {

    /**
     * API to get the reports of sold tickets for the given date and hall
     *
     * @param authorizationHeader authorizationHeader
     * @param hallId hall Id
     * @param date date
     * @return report
     */
    @ApiOperation(value = "API to get the reports of sold tickets for the given date and hall")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the report"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "report not found")})
    @GetMapping("/admin/ticket-report/{hallId}/{date}")
    public List<TicketReportResponseDto> getSoldTicketReport(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("hallId") String hallId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        return null;
    }

    /**
     * API to update user role
     *
     * @param authorizationHeader authorizationHeader
     * @param emailId user email Id
     * @param roleId new role Id
     * @return update status
     */
    @ApiOperation(value = "API to update user role")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully updated the role"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "user not found")})
    @PostMapping("/admin/{emailId}/{roleId}")
    public ResponseEntity<String> updateRole(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("emailId") String emailId, @PathVariable("roleId") String roleId) {
        return null;
    }

    /**
     * API to fetch all the released movies
     *
     * @param authorizationHeader authorizationHeader
     * @return list of movies
     */
    @ApiOperation(value = "API to fetch all the releasing movies")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the movies"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "movies not found")})
    @GetMapping("/admin/movie")
    public List<MovieResponseDto> getMovie(@RequestHeader("Authorization") String authorizationHeader) {
        return null;
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
