package com.example.demo.controller;

import com.example.demo.model.dto.MovieTicketResponseDto;
import com.example.demo.model.dto.TicketBookingRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for MovieHall ticket booking/cancellation APIs
 */
@RestController
@Validated
@Tag(name = "MovieTicket", description = "APIs for booking and cancelling tickets in movie halls")
public class MovieTicketController {

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
            @PathVariable("ticketId") @NotNull Integer ticketId) {
        return null;
    }
}
