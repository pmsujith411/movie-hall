package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8041691215923397088L;

    private String userId;

    private String userName;

    private String password;

    private String emailId;

    private boolean status;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
