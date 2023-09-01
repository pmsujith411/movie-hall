package com.example.demo.model.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class MovieTicketResponseDto {

    private String ticketId;

    private String movieName;

    private Float bookingAmount;

    private OffsetDateTime showTime;

    private String screenNumber;

    private List<String> seatNumbers;
}
