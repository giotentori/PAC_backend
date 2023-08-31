package com.example.pacbackend.UserPage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pacbackend.Users.User.User;

public interface UserPageRepository extends JpaRepository<User, Long> {


    Optional<User> findByOrdine(String id);

}
