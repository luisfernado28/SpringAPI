package com.luisapi.userApi.dto;

import org.springframework.stereotype.Component;
import com.luisapi.userApi.Models.User;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserCreateDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public void updateEntityFromDto(UserUpdateDto dto, User user) {
        if (dto == null || user == null) return;
        if (dto.getName() != null) {
            user.setName(dto.getName());
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
    }
}