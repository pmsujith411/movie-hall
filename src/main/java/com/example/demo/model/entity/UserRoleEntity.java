package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class UserRoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7380898272565011463L;

    private Integer userId;

    private String role;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
