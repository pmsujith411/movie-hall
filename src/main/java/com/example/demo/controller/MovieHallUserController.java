package com.example.demo.controller;

import com.example.model.dto.MovieHallResponseDto;
import com.example.model.dto.MovieTicketResponseDto;
import com.example.model.dto.AvailableScreenResponseDto;
import com.example.model.dto.SeatResponseDto;
import com.example.model.dto.TicketBookingRequestDto;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controller for MovieHall application user APIs
 */
@RestController
@Validated
@Api(tags = "APIs for booking tickets in movie halls")
public class MovieHallUserController {

    /**
     * API to fetch all movie halls for the given town
     *
     * @param authorizationHeader authorizationHeader
     * @param townId town Id
     * @return list of movie halls
     */
    @ApiOperation(value = "API to fetch all movie halls for the given town")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the movie halls"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "town not found")})
    @GetMapping("/movie-hall/{townId}")
    public List<MovieHallResponseDto> getMovieHall(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("townId") String townId) {
        return null;
    }

    /**
     * API to fetch screens for booking the tickets for the given movie hall
     *
     * @param authorizationHeader authorizationHeader
     * @param movieHallId movieHall Id
     * @param date date
     * @return list of available screens
     */
    @ApiOperation(value = "API to fetch screens for booking the tickets for the given movie hall")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the screens"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "movie hall not found")})
    @GetMapping("/available-screen/{movieHallId}")
    public List<AvailableScreenResponseDto> getAvailableScreen(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("movieHallId") String movieHallId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> date) {
        return null;
    }

    /**
     * API to fetch the available seats for the given schedule
     *
     * @param authorizationHeader authorizationHeader
     * @param scheduleId schedule Id
     * @return list of available seats
     */
    @ApiOperation(value = "API to fetch the available seats for the given screen")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully retrieved the available seats"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "screen not found")})
    @GetMapping("/seat/{scheduleId}")
    public List<SeatResponseDto> getAvailableSeat(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("scheduleId") String scheduleId) {
        return null;
    }

    /**
     * API to book tickets for the given user
     *
     * @param authorizationHeader authorizationHeader
     * @param ticketBookingRequest request
     * @return ticket details
     */
    @ApiOperation(value = "API to book tickets for the given user")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully booked the ticket"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @PostMapping("/book-ticket")
    public MovieTicketResponseDto bookTicket(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @Valid TicketBookingRequestDto ticketBookingRequest) {
        return null;
    }

    /**
     * API to cancel a booked ticket for the given user
     *
     * @param authorizationHeader authorizationHeader
     * @param ticketId ticket Id
     * @return cancel status
     */
    @ApiOperation(value = "API to cancel a booked ticket for the given user")
    @ApiResponses({@ApiResponse(code = 200, message = "Successfully cancelled the ticket"),
            @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 404, message = "ticket not found")})
    @PostMapping("/cancel-ticket/{ticketId}")
    public ResponseEntity<String> cancelTicket(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("ticketId") String ticketId) {
        return null;
    }
}
