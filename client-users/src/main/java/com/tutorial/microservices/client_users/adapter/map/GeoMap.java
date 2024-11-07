package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.GeoEntity;
import com.tutorial.microservices.client_users.domain.Geo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoMap {

    GeoMap INSTANCE = Mappers.getMapper(GeoMap.class);

    GeoEntity convertToEntity(Geo geo);

    Geo convertToDomain(GeoEntity geo);

}
