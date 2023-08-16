package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieHall implements Serializable {

    private static final long serialVersionUID = -1450772400936338929L;

    private String hallId;

    private String hallName;

    private String townId;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
