package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.CompanyEntity;
import com.tutorial.microservices.client_users.domain.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMap {

    CompanyMap INSTANCE = Mappers.getMapper(CompanyMap.class);

    CompanyEntity convertToEntity(Company company);

    Company convertToDomain(CompanyEntity company);

}
