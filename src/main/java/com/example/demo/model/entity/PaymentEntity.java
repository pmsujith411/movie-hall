package com.example.demo.model.entity;

import com.example.demo.enumeration.PaymentType;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = -2077594600679010019L;

    private String paymentId;

    private String userId;

    private PaymentType paymentType;

    private Float paymentAmount;

    private String paymentStatus;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}
