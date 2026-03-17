package com.example.session13homework.repository;

import com.example.session13homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long > {

    Optional<User> findByUsername (String username )  ;

}
