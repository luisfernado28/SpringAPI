package com.luisapi.userApi.Repository;

import com.luisapi.userApi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}