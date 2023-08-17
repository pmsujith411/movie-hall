package com.example.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class TicketBookingRequestDto implements Serializable {

    private static final long serialVersionUID = -1539783739608169095L;

    @NotBlank
    private String scheduleId;

    @NotEmpty
    private List<String> seatIds;
}
