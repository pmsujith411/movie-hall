package com.example.demo.enumeration;

public enum PaymentType {

    CREDIT_CARD("CREDIT_CARD"),
    UPI("UPI"),
    DEBIT_CARD("DEBIT_CARD");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
