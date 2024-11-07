package com.tutorial.microservices.client_users.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;
    private Set<Post> posts;

}
