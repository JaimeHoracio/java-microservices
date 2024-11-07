package com.tutorial.microservices.client_users.adapter.out.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Table(name = "Users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;
    @Column(unique = true)
    private String username;
    private String email;
    private String phone;
    private String website;

    /**
     * Con mappedBy le indico que la responsabilidad de crear la clave foránea es de la entidad AddressEntity
     **/
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private AddressEntity address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private CompanyEntity company;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostEntity> posts;

    public void setAddress(AddressEntity address) {
        this.address = address;
        if (!Objects.isNull(address)) {
            address.setUser(this);
        }
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
        if (!Objects.isNull(company)) {
            company.setUser(this);
        }
    }

}
