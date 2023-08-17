package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScreenResponseDto  implements Serializable {

    private static final long serialVersionUID = -4972305533419987268L;

    private String screenId;

    private Integer screenNumber;

    private Integer seatCount;
}
