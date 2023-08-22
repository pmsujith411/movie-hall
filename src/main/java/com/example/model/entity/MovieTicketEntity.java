package com.example.model.entity;

import com.example.enumeration.BookingStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieTicketEntity implements Serializable {

    private static final long serialVersionUID = 7654944166912222729L;

    private String ticketId;

    private String userId;

    private String scheduleId;

    private String paymentId;

    private Float bookingAmount;

    private BookingStatus bookingStatus;

    private OffsetDateTime showDate;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
