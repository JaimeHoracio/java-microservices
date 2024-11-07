package com.tutorial.microservices.client_users.service.port.out;

import com.tutorial.microservices.client_users.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserOUT {

    Long addUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUserById(Long idUser);
}
