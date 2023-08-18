package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScreenResponseDto implements Serializable {

    private static final long serialVersionUID = -1589745318601908581L;

    private String screenId;

    private Integer screenNumber;

    private Integer seatCount;
}
