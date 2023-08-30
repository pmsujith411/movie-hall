package com.example.demo.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = -7380898272565011463L;

    private Long userId;

    private String role;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
