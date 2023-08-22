package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeatTypeResponseDto implements Serializable {

    private static final long serialVersionUID = 5975139860819403570L;

    private String type;

    private Float rate;
}
