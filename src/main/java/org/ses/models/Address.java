package org.ses.models;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address() {}
}
