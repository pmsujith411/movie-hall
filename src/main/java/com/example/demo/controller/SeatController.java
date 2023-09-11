package com.example.demo.controller;

import com.example.demo.model.dto.SeatResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for seat related services
 */
@Tag(name = "Screen", description = "APIs for seat related services")
@RequestMapping("/seat")
@Validated
@RestController
public class SeatController {

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
}
