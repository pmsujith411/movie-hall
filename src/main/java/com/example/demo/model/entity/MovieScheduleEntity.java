package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

@Data
public class MovieScheduleEntity implements Serializable {

    private static final long serialVersionUID = 8402146860559456641L;

    private String scheduleId;

    private String movieId;

    private String screenId;

    private OffsetDateTime fromDate;

    private OffsetDateTime toDate;

    private OffsetTime showTime;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
