package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.UserEntity;
import com.tutorial.microservices.client_users.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {AddressMap.class, CompanyMap.class, PostMap.class, CommentMap.class})
public interface UserMap {

    UserMap INSTANCE = Mappers.getMapper(UserMap.class);

    UserEntity convertToEntity(User user);

    User convertToDomain(UserEntity user);

    List<User> convertToListDomain(List<UserEntity> user);
}
