package com.luisapi.userApi.Services;

import com.luisapi.userApi.Models.User;
import com.luisapi.userApi.Repository.UserRepository;
import com.luisapi.userApi.dto.UserCreateDto;
import com.luisapi.userApi.dto.UserMapper;
import com.luisapi.userApi.dto.UserUpdateDto;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements InnerUserService {

    private final UserRepository userRepository;

    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserCreateDto user) {
        User userEntity = userMapper.toEntity(user);
        return userRepository.save(userEntity);
    }

    public User updateUser(Long id, UserUpdateDto updatedUser) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedUser.getName());
                    existing.setEmail(updatedUser.getEmail());
                    return userRepository.save(existing);
                })
                .orElse(null);
    }

    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) return false;
        userRepository.deleteById(id);
        return true;
    }
}
