package com.example.demo.controller;

import com.example.demo.model.dto.AvailableScreenResponseDto;
import com.example.demo.model.dto.request.ScreenRequestDto;
import com.example.demo.model.dto.response.ScreenResponseDto;
import com.example.demo.service.ScreenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @Autowired
    private ScreenService screenService;

    /**
     * API to fetch all the screens for the given movie hall
     *
     * @param authorizationHeader authorizationHeader
     * @param hallId movieHall Id
     * @return list of screens
     */
    @Operation(summary = "API to fetch all the screens for the given movie hall")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Successfully retrieved the screens"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "screen not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{hallId}")
    public List<ScreenResponseDto> getScreen(@RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("hallId") @NotNull Integer hallId) {
        return screenService.getScreen(hallId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createScreen(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @NotNull List<@Valid ScreenRequestDto> screenRequestDtoList) {
        screenService.createScreen(screenRequestDtoList);
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
            @ApiResponse(responseCode = "404", description = "screen not found")})
    @GetMapping("/available-screen/{movieHallId}")
    public List<AvailableScreenResponseDto> getAvailableScreen(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("movieHallId") @NotNull Integer movieHallId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> date) {
        return null;
    }
}
