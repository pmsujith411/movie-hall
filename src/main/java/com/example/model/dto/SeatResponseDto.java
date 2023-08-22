package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeatResponseDto implements Serializable {

    private static final long serialVersionUID = 669529175787200491L;

    private String seatId;

    private Integer seatNumber;

    private SeatTypeResponseDto seatType;
}
