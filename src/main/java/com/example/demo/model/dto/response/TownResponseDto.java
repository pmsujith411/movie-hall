package com.example.demo.model.dto.response;

import java.io.Serializable;

/**
 * record for town request dto
 */
public record TownResponseDto(String townId, String townName) implements Serializable {
}
