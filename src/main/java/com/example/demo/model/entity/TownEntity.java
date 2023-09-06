package com.example.demo.model.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
public class TownEntity implements Serializable {

    private static final long serialVersionUID = 1086633130699965771L;

    private String townId;

    private String townName;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
