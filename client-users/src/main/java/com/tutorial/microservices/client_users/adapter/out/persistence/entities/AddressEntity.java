package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressEntity {

    @Id
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    /**
     * Con la anotación @MapsId le indico a Hibernate que quiero que el id (PK) herede el valor del Padre (UserEntity).
     * Con @JoinColumn le estamos asignando un nombre a la columna del PK (es PK porque estamos usando @MapsId, sino se
     * creaba otra columna y apuntaba a la PK de UserEntity).
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @MapsId
    private UserEntity user;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private GeoEntity geoEntity;

    public void setGeoEntity(GeoEntity geo) {
        this.geoEntity = geo;
        if (!Objects.isNull(geo)) {
            geo.setAddress(this);
        }
    }
}
