package com.tutorial.microservices.client_users.adapter.map;

import com.tutorial.microservices.client_users.adapter.out.persistence.entities.CommentEntity;
import com.tutorial.microservices.client_users.domain.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CommentMap {

    CommentMap INSTANCE = Mappers.getMapper(CommentMap.class);

    @Mapping(source = "postId", target = "commentPostId.postId")
    @Mapping(source = "id", target = "commentPostId.commentId")
    CommentEntity convertToEntity(Comment comment);

    @Mapping(source = "commentPostId.postId", target = "postId")
    @Mapping(source = "commentPostId.commentId", target = "id")
    Comment convertToDomain(CommentEntity comment);

    Set<Comment> convertToSetDomain(Set<CommentEntity> post);
}
