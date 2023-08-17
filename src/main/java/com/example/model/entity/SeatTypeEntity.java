package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class SeatTypeEntity implements Serializable {

    private static final long serialVersionUID = -5110125038465315928L;

    private String typeId;

    private String type;

    private Float rate;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
