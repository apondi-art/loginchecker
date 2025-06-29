package com.example.userauth.repository;

import com.example.userauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// talks directly to the database to save, update, delete, and fetch user records instead of writing SQL queries
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
