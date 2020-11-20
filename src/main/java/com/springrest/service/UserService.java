package com.springrest.service;

import com.springrest.dto.UserDto;
import com.springrest.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserDto> allUsers();

    void deleteUser(Long id);

    void saveUser(User user);

    void edit(User user);

    User getUserById(Long id);

    boolean ifExists(Long id);

}

