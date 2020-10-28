package com.springrest.dtoservice;

import com.springrest.dto.UserDto;
import com.springrest.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoServiceImpl implements UserDtoService {
    @Override
    public UserDto userConvertToDTOUser(User user) {
        UserDto userDto = new UserDto();

        userDto.setuId(user.getId());
        userDto.setuNickname(user.getNickname());
        userDto.setuFirstName(user.getFirstName());
        userDto.setuLastName(user.getLastName());
        userDto.setuAge(user.getAge());
        userDto.setuEmail(user.getEmail());
        userDto.setuSetRoles(user.getRoles());
        userDto.setuPassword(user.getPassword());
        userDto.setuConfirmPassword(user.getConfirmPassword());

        return userDto;
    }

    @Override
    public User dtoConvertToUser(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getuId());
        user.setNickname(userDto.getuNickname());
        user.setFirstName(userDto.getuFirstName());
        user.setLastName(userDto.getuLastName());
        user.setAge(userDto.getuAge());
        user.setEmail(userDto.getuEmail());
        user.setRoles(userDto.getuSetRoles());
        user.setPassword(userDto.getuPassword());
        user.setConfirmPassword(userDto.getuConfirmPassword());

        return user;
    }

    @Override
    public List<UserDto> userListConvertToDTO(List<User> users) {
        List<UserDto> userDto = new ArrayList<>();
        users.forEach(user -> userDto.add(userConvertToDTOUser(user)));
        return userDto;
    }

    @Override
    public UserDto getAuthUserInfo(User user) {
        return userConvertToDTOUser(user);
    }
}
