package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.AddressEntity;
import com.tutorial.microservices.client_users.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GeoMap.class})
public interface AddressMap {

    AddressMap INSTANCE = Mappers.getMapper(AddressMap.class);

    //Se utiliza @Mapping cuando los atributos no coinciden en el nombre.
    @Mapping(source = "geo", target = "geoEntity")
    AddressEntity convertToEntity(Address address);

    @Mapping(source = "geoEntity", target = "geo")
    Address convertToDomain(AddressEntity address);

}
