package com.example.demo.controller;

import com.example.demo.model.dto.MovieHallResponseDto;
import com.example.demo.model.dto.MovieTicketResponseDto;
import com.example.demo.model.dto.AvailableScreenResponseDto;
import com.example.demo.model.dto.SeatResponseDto;
import com.example.demo.model.dto.TicketBookingRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controller for MovieHall ticket booking/cancellation APIs
 */
@RestController
@Validated
@Tag(name = "MovieTicket", description = "APIs for booking and cancelling tickets in movie halls")
public class MovieTicketController {

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
            @ApiResponse(responseCode = "404", description = "town not found")})
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
    @Operation(description = "API to fetch screens for booking the tickets for the given movie hall")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the screens"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "movie hall not found")})
    @GetMapping("/available-screen/{movieHallId}")
    public List<AvailableScreenResponseDto> getAvailableScreen(
            @RequestHeader("Authorization") String authorizationHeader, @PathVariable("movieHallId") String movieHallId,
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
    @Operation(description = "API to fetch the available seats for the given screen")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the available seats"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "screen not found")})
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
    @Operation(description = "API to book tickets for the given user")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully booked the ticket"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
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
    @Operation(description = "API to cancel a booked ticket for the given user")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully cancelled the ticket"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "ticket not found")})
    @PostMapping("/cancel-ticket/{ticketId}")
    public ResponseEntity<String> cancelTicket(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("ticketId") String ticketId) {
        return null;
    }
}
