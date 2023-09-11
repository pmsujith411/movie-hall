package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class SeatEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5586472184378826726L;

    private Integer seatId;

    private Integer screenId;

    private String seatNumber;

    private String seatType;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
