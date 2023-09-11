package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class TownEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1086633130699965771L;

    private Integer townId;

    private String townName;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
