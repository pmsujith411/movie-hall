package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class ScreenEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1589745318601908581L;

    private Integer screenId;

    private Integer screenNumber;

    private Integer hallId;

    private boolean status;

    private Integer seatCount;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
