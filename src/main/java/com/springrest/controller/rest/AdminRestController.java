package com.springrest.controller.rest;

import com.springrest.dto.UserDto;
import com.springrest.model.User;
import com.springrest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("admin/allUsers")
    public ResponseEntity<List<UserDto>> userList() {
        List<User> users = userService.allUsers();

        List<UserDto> userDto = new ArrayList<>();
        users.forEach(user -> userDto.add(new UserDto(user)));
        return userDto != null && !userDto.isEmpty()
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("admin/userAuth")
    public ResponseEntity<UserDto> getAuthUser() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        UserDto userDto = new UserDto(user);
        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("admin/add")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto userDto) {
        try {
            userService.saveUser(new User(userDto));
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("admin/edit")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        try {
            userService.edit(new User(userDto));
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("admin/edit/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        UserDto userDto = new UserDto(userService.getUserById(id));
        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
