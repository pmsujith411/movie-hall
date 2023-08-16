package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Screen implements Serializable {

    private static final long serialVersionUID = -1589745318601908581L;

    private String screenId;

    private Integer screenNumber;

    private String hallId;

    private boolean status;

    private Integer seatCount;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
