package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetTime;

@Data
public class AvailableScreenResponseDto implements Serializable {

    private static final long serialVersionUID = -4972305533419987268L;

    private String scheduleId;

    private Integer screenNumber;

    private String movieName;

    private OffsetTime showTime;
}
