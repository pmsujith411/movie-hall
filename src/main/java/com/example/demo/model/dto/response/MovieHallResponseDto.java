package com.example.demo.model.dto.response;

import java.io.Serializable;

/**
 * record for movie hall response dto
 */
public record MovieHallResponseDto(Integer hallId, String hallName) implements Serializable {
}
