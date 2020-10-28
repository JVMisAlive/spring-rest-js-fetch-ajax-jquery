package com.springrest.controller.rest;

import com.springrest.dto.UserDto;
import com.springrest.dtoservice.UserDtoService;
import com.springrest.model.User;
import com.springrest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AdminRestController {

    private final UserService userService;
    private final UserDtoService userDtoService;

    public AdminRestController(UserService userService, UserDtoService userDtoService) {
        this.userService = userService;
        this.userDtoService = userDtoService;
    }

    @GetMapping("admin/allUsers")
    public ResponseEntity<List<UserDto>> userList() {
        List<UserDto> dtoList = userDtoService.userListConvertToDTO(userService.allUsers());
        return dtoList != null && !dtoList.isEmpty()
                ? new ResponseEntity<>(dtoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("admin/userAuth")
    public ResponseEntity<UserDto> getAuthUser() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        UserDto userDto = userDtoService.userConvertToDTOUser(user);
        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("admin/add")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto userDto) {
        try {
            userService.saveUser(userDtoService.dtoConvertToUser(userDto));
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("admin/edit")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        try {
            userService.edit(userDtoService.dtoConvertToUser(userDto));
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("admin/edit/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        UserDto userDto = userDtoService.userConvertToDTOUser(userService.getUserById(id));
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
