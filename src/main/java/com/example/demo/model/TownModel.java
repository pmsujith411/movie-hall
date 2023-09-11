package com.example.demo.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * model for town
 */
@Data
public class TownModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 661555670041242060L;

    private Integer townId;

    private String townName;
}
