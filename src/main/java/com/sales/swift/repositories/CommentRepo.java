package com.sales.swift.repositories;


import com.sales.swift.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findByCustomerId(Long customerId);

}
