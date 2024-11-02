package com.loginauthapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginauthapi.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmail( String email );
}
