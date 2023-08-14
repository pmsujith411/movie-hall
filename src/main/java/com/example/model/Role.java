package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -7380898272565011463L;

    private String roleId;

    private String roleName;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
