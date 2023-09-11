package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8041691215923397088L;

    private Integer userId;

    private String userName;

    private String emailId;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
