package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieHallEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1450772400936338929L;

    private Integer hallId;

    private String hallName;

    private Integer townId;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
