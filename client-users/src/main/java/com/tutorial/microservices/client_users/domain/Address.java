package com.tutorial.microservices.client_users.domain;

import lombok.Data;

@Data
public class Address {

    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

}
