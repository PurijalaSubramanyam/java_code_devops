package com.crud.program.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.program.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
