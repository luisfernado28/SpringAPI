package com.luisapi.userApi.Services;

import com.luisapi.userApi.Models.User;
import com.luisapi.userApi.dto.UserCreateDto;
import com.luisapi.userApi.dto.UserUpdateDto;

import java.util.List;

public interface InnerUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(UserCreateDto user);
    User updateUser(Long id, UserUpdateDto updatedUser);
    boolean deleteUser(Long id);

}
