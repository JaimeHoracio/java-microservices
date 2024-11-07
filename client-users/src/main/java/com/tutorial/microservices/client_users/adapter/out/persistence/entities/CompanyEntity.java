package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "company")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyEntity {

    @Id
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;

    @OneToOne
    @JoinColumn(name = "company_id")
    @MapsId
    private UserEntity user;
}
