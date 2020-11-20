package com.springrest.controller.rest;

import com.springrest.dto.UserDto;
import com.springrest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/**")
public class UserRestController {

    @GetMapping("authUser")
    public ResponseEntity<UserDto> getAuthUser() {
        User user = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        UserDto dtoUser = new UserDto(user);
        return new ResponseEntity<>(dtoUser, HttpStatus.OK);
    }

}