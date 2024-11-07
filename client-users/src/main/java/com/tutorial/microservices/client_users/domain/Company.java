package com.tutorial.microservices.client_users.domain;

import lombok.Data;

@Data
public class Company {

    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;
}
