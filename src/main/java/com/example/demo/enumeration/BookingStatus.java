package com.example.demo.enumeration;

public enum BookingStatus {

    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED");

    private String value;

    BookingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
