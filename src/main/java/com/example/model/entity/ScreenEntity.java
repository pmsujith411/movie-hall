package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class ScreenEntity implements Serializable {

    private static final long serialVersionUID = -1589745318601908581L;

    private String screenId;

    private Integer screenNumber;

    private String hallId;

    private boolean status;

    private Integer seatCount;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
