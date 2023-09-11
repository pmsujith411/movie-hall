package com.example.demo.model.dto.response;

import java.io.Serializable;

/**
 * record for town request dto
 */
public record TownResponseDto(Integer townId, String townName) implements Serializable {
}
