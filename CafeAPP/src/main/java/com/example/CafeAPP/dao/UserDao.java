package com.example.CafeAPP.dao;

import com.example.CafeAPP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserDao extends JpaRepository<User, Integer> {
    // Custom query methods can be defined here, JPA provides ready-to-use CRUD operations, support for custom queries, and seamless integration with JPA providers like Hibernate. By extending JpaRepository, you can focus on the business logic.
    User findByEmailId(@Param("email") String email);
}
