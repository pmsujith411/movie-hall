package com.example.demo.controller;

import com.example.demo.model.dto.AvailableScreenResponseDto;
import com.example.demo.model.dto.ScreenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controller for screen related services
 */
@Tag(name = "Screen", description = "APIs for screen related services")
@RequestMapping("/screen")
@Validated
@RestController
public class ScreenController {

    /**
     * API to fetch all the screens for the given movie hall
     *
     * @param authorizationHeader authorizationHeader
     * @param movieHallId movieHall Id
     * @return list of screens
     */
    @Operation(summary = "API to fetch all the screens for the given movie hall")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the screens"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "movie hall not found")})
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{movieHallId}")
    public List<ScreenResponseDto> getScreen(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("movieHallId") @NotNull Integer movieHallId) {
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
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("movieHallId") @NotNull Integer movieHallId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> date) {
        return null;
    }
}
