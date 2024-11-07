package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "geo")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GeoEntity {
    @Id
    private Long id;
    private String lat;
    private String lng;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geo_id")
    @MapsId
    private AddressEntity address;
}
