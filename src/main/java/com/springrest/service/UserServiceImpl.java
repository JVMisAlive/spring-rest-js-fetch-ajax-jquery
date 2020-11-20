package com.springrest.service;

import com.springrest.dto.UserDto;
import com.springrest.model.User;
import com.springrest.repository.RoleRepository;
import com.springrest.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        User user = userRepository.getUserByNickname(nickname);
        if (user == null) {
            System.err.println("User not found");
        }
        return user;
    }

    @Override
    public List<UserDto> allUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = new ArrayList<>();
        users.forEach(user -> userDto.add(new UserDto(user)));
        return userDto;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean ifExists(Long id) {
        return userRepository.existsById(id);
    }
}
