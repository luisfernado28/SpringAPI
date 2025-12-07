package com.luisapi.userApi.Services;

import com.luisapi.userApi.Models.User;

import java.util.List;

public interface InnerUserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);

}
