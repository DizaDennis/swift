package com.sales.swift.controllers;

import com.sales.swift.entities.Comment;
import com.sales.swift.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    public CommentRepo commentRepo;

    @GetMapping("")
    @ResponseBody
    public List<Comment> getComments(@PathVariable Long customerId){

        List<Comment> findByCustomerId = commentRepo.findByCustomerId(customerId);
        return findByCustomerId;
    }
}
