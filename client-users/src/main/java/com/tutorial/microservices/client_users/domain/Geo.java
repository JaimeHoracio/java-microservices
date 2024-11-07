package com.tutorial.microservices.client_users.domain;

import lombok.Data;

@Data
public class Geo {

    private Long id;
    private String lat;
    private String lng;
}
