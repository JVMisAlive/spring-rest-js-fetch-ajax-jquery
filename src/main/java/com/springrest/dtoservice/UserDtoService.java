package com.springrest.dtoservice;

import com.springrest.dto.UserDto;
import com.springrest.model.User;

import java.util.List;

public interface UserDtoService {
    UserDto userConvertToDTOUser(User user);

    User dtoConvertToUser(UserDto userDto);

    List<UserDto> userListConvertToDTO(List<User> users);

    UserDto getAuthUserInfo(User user);
}
