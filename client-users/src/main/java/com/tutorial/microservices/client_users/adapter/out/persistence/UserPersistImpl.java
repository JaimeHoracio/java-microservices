package com.tutorial.microservices.client_users.adapter.out.persistence;

import com.tutorial.microservices.client_users.adapter.map.UserMap;
import com.tutorial.microservices.client_users.adapter.out.persistence.entities.UserEntity;
import com.tutorial.microservices.client_users.domain.User;
import com.tutorial.microservices.client_users.service.port.out.IUserOUT;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserPersistImpl implements IUserOUT {

    private final IUserPersist iUserPersist;

    @Override
    public Long addUser(User user) {
        try {
            UserEntity result = iUserPersist.save(UserMap.INSTANCE.convertToEntity(user));
            return result.getId();
        }
        catch (ConstraintViolationException ex) {
            log.error(String.format(">>> Error de constrain: %s", ex.getMessage()));
            throw ex;
        }
        catch (Exception ex) {
            log.error(String.format(">>> Error al agregar usuario: %s", ex.getMessage()));
            throw ex;
        }
    }

    @Override
    public User getUserById(Long id) {
        var user = iUserPersist.findById(id);
        if (user.isPresent()) {
            return UserMap.INSTANCE.convertToDomain(user.get());
        } else {
            throw new EntityNotFoundException(String.format("No se encontró Usuario con identicador: %s", id));
        }
    }

    @Override
    public List<User> getAllUsers() {
        return UserMap.INSTANCE.convertToListDomain(iUserPersist.findAll());
    }

    @Override
    public void updateUser(User user) {
        iUserPersist.save(UserMap.INSTANCE.convertToEntity(user));
    }

    @Override
    public void deleteUserById(Long idUser) {
        var user = getUserById(idUser);
        user.setPosts(new HashSet<>());
        updateUser(user);
        iUserPersist.delete(UserMap.INSTANCE.convertToEntity(user));
    }
}
