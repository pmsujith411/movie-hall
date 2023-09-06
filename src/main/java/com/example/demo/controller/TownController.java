package com.example.demo.controller;

import com.example.demo.model.dto.response.TownResponseDto;
import com.example.demo.service.TownService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for APIs related to town related operation
 */
@Tag(name = "Movie", description = "APIs for movie related services")
@RequestMapping("/town")
@Validated
@RestController
public class TownController {

    @Autowired
    private TownService townService;

    /**
     * API to create towns
     *
     * @param townList list of towns
     */
    @Operation(summary = "API to create towns")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void createTown(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody @NotNull List<@NotBlank String> townList) {
        townService.createTown(townList);
    }

    /**
     * API to get all the towns
     *
     * @return list of towns
     */
    @Operation(summary = "API to get all the towns")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping
    public List<TownResponseDto> getTown(@RequestHeader("Authorization") String authorizationHeader) {
        return townService.getTown();
    }
}
