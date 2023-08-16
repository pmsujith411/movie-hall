package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Town implements Serializable {

    private static final long serialVersionUID = 1086633130699965771L;

    private String townId;

    private String townName;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
