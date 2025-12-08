package com.luisapi.userApi;

import com.luisapi.userApi.Models.User;
import com.luisapi.userApi.Services.InnerUserService;
import com.luisapi.userApi.dto.UserCreateDto;
import com.luisapi.userApi.dto.UserUpdateDto;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final InnerUserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(InnerUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null
                ? ResponseEntity.ok(user)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDto newUser) {
        logger.info("Creating new user with name: {}", newUser.getName());
        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateDto updatedUser
    ) {
        User user = userService.updateUser(id, updatedUser);
        return user != null
                ? ResponseEntity.ok(user)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/status")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from UsersController!");
    }
}
