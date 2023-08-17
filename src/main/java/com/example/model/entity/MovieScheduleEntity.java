package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class MovieScheduleEntity implements Serializable {

    private static final long serialVersionUID = 8402146860559456641L;

    private String scheduleId;

    private String movieId;

    private String screenId;

    private OffsetDateTime fromDate;

    private OffsetDateTime toDate;

    private String showTime;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
