package com.sales.swift.repositories;

import com.sales.swift.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class/interface is to help with CRUD ops. Leverages Spring Data JPA to make CRUD ops easy
 * This Repo is specifically to look up users in the DB
 *
 * @author dennisdiza
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     /*
     'findBy runs the relevant SQL script to find the user in the DB
     Does this by working off a property in the user class
      */
    User findByUsername(String username);
}
