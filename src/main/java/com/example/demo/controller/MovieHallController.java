package com.example.demo.controller;

import com.example.model.dto.MovieHallResponseDto;
import com.example.model.dto.MovieScheduleRequestDto;
import com.example.model.dto.ScreenResponseDto;
import com.example.model.dto.SeatResponseDto;
import com.example.model.dto.TicketBookingRequestDto;
import com.example.model.dto.TicketReportResponseDto;
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
public class MovieHallController {

    /**
     * API to update user role
     *
     * @param emailId user email Id
     * @param roleId new role Id
     * @return update status
     */
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
    @GetMapping("ticket-report/{hallId}/{date}")
    public List<TicketReportResponseDto> getSoldTicketReport(@PathVariable("hallId") String hallId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        return null;
    }
}
