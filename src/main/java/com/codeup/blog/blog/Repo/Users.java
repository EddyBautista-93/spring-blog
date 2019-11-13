package com.codeup.blog.blog.Repo;

import com.codeup.blog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
