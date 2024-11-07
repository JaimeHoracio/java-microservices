package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.PostEntity;
import com.tutorial.microservices.client_users.domain.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = {CommentMap.class})
public interface PostMap {

    PostMap INSTANCE = Mappers.getMapper(PostMap.class);

    @Mapping(source = "userId", target = "postUserId.userId")
    @Mapping(source = "id", target = "postUserId.postId")
    PostEntity convertToEntity(Post post);

    @Mapping(source = "postUserId.userId", target = "userId")
    @Mapping(source = "postUserId.postId", target = "id")
    Post convertToDomain(PostEntity post);

    Set<Post> convertToSetDomain(Set<PostEntity> post);
}
