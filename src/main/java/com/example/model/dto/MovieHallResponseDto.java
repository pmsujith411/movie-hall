package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MovieHallResponseDto implements Serializable {

    private static final long serialVersionUID = 5801920103706120543L;

    private String hallId;

    private String hallName;

    private List<ScreenResponseDto> screens;
}
