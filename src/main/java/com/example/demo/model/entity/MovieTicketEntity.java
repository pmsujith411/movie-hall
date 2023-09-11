package com.example.demo.model.entity;

import com.example.demo.enumeration.BookingStatus;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieTicketEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7654944166912222729L;

    private Integer ticketId;

    private Integer userId;

    private Integer scheduleId;

    private Integer paymentId;

    private Float bookingAmount;

    private BookingStatus bookingStatus;

    private OffsetDateTime showDate;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
