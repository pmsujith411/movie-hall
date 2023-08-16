package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Seat implements Serializable {

    private static final long serialVersionUID = -5586472184378826726L;

    private String seatId;

    private String screenId;

    private Integer seatNumber;

    private String seatType;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
