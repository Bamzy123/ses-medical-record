package org.ses.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address() {}

    public Address(String street, String city, String state, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}
