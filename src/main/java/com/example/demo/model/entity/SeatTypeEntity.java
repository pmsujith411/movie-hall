package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class SeatTypeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5110125038465315928L;

    private Integer typeId;

    private String type;

    private Float rate;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
