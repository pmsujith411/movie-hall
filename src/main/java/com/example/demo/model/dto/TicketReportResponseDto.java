package com.example.demo.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TicketReportResponseDto implements Serializable {

    private static final long serialVersionUID = 1371548512708807279L;

    private String screenNumber;

    private String totalTicketsSold;

    private Float totalRevenue;
}
