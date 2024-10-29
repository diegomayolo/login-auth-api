package com.loginauthapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginauthapi.domain.user.User;

public interface UserRepository extends JpaRepository<User, String>
{}
