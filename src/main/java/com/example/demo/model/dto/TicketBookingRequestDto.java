package com.example.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TicketBookingRequestDto implements Serializable {

    private static final long serialVersionUID = -1539783739608169095L;

    @NotBlank
    private String scheduleId;

    @NotEmpty
    private List<String> seatIds;

    @NotBlank
    private String paymentId;

    @NotBlank
    private String paymentType;

    @NotNull
    private Float paymentAmount;
}
