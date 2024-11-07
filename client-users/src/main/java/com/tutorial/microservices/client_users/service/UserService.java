package com.tutorial.microservices.client_users.service;

import com.tutorial.microservices.client_users.domain.User;
import com.tutorial.microservices.client_users.service.port.in.IUserIN;
import com.tutorial.microservices.client_users.service.port.out.IUserOUT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserIN {

    @Qualifier("IUserOUT")
    private final IUserOUT userOUT;

    @Override
    public Long addUser(User user) {
        return userOUT.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userOUT.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userOUT.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userOUT.updateUser(user);
    }

    @Override
    public void deleteUserById(Long idUser) {
        userOUT.deleteUserById(idUser);
    }

}
