package com.example.demo.controller;

import com.example.model.dto.MovieHallResponseDto;
import com.example.model.dto.MovieScheduleRequestDto;
import com.example.model.dto.ScreenResponseDto;
import com.example.model.dto.SeatResponseDto;
import com.example.model.dto.TicketBookingRequestDto;
import com.example.model.dto.TicketReportResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for MovieHall application
 */
@RestController
@Validated
@Api(tags = "APIs for managing movie halls")
public class MovieHallController {

    /**
     * API to update user role
     *
     * @param emailId user email Id
     * @param roleId new role Id
     * @return update status
     */
    @ApiOperation(value = "API to update user role")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully updated the role"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "user not found")
    })
    @PostMapping("/user/{emailId}/{roleId}")
    public ResponseEntity<String> updateRole(@PathVariable("emailId") String emailId,
            @PathVariable("roleId") String roleId) {
        return null;
    }

    /**
     * API to upload movie schedules
     *
     * @param movieScheduleRequest movie schedule request
     * @return status
     */
    @ApiOperation(value = "API to upload movie schedules")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successfully created the movie schedule"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/movie-upload")
    public ResponseEntity<String> uploadMovieSchedule(
            @RequestBody @Valid List<MovieScheduleRequestDto> movieScheduleRequest) {
        return null;
    }

    /**
     * API to book tickets for the given user
     *
     * @param ticketBookingRequest request
     * @return booking status
     */
    @ApiOperation(value = "API to book tickets for the given user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully booked the ticket"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/book-ticket")
    public ResponseEntity<String> bookTicket(@RequestBody @Valid TicketBookingRequestDto ticketBookingRequest) {
        return null;
    }

    /**
     * API to fetch all movie halls for the given town
     *
     * @param townId town Id
     * @return list of movie halls
     */
    @ApiOperation(value = "API to fetch all movie halls for the given town")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully retrieved the movie halls"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "town not found")
    })
    @GetMapping("/movie-hall/{townId}")
    public List<MovieHallResponseDto> getMovieHall(@PathVariable("townId") String townId) {
        return null;
    }

    /**
     * API to fetch screens for the given movie hall
     *
     * @param movieHallId movieHall Id
     * @return list of screens
     */
    @ApiOperation(value = "API to fetch screens for the given movie hall")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully retrieved the screens"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "movie hall not found")
    })
    @GetMapping("/screen/{movieHallId}")
    public List<ScreenResponseDto> getScreen(@PathVariable("movieHallId") String movieHallId) {
        return null;
    }

    /**
     * API to fetch the available seats for the given screen
     *
     * @param screenId screen Id
     * @return list of available seats
     */
    @ApiOperation(value = "API to fetch the available seats for the given screen")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully retrieved the available seats"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "screen not found")
    })
    @GetMapping("/seat/{screenId}")
    public List<SeatResponseDto> getAvailableSeat(@PathVariable("screenId") String screenId) {
        return null;
    }

    /**
     * API to cancel a booked ticket for the given user
     *
     * @param userId user Id
     * @param ticketId ticket Id
     * @return cancel status
     */
    @ApiOperation(value = "API to cancel a booked ticket for the given user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully cancelled the ticket"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "ticket not found")
    })
    @PostMapping("/cancel-ticket/{userId}/{ticketId}")
    public ResponseEntity<String> cancelTicket(@PathVariable("userId") String userId,
            @PathVariable("ticketId") String ticketId) {
        return null;
    }

    /**
     * API to get the reports of sold tickets for the given date and hall
     *
     * @param hallId hall Id
     * @param date date
     * @return report
     */
    @ApiOperation(value = "API to get the reports of sold tickets for the given date and hall")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully retrieved the report"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "report not found")
    })
    @GetMapping("ticket-report/{hallId}/{date}")
    public List<TicketReportResponseDto> getSoldTicketReport(@PathVariable("hallId") String hallId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        return null;
    }
}
