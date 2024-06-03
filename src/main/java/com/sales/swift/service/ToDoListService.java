package com.sales.swift.service;

import com.sales.swift.entities.ToDoList;

import java.util.List;

public interface ToDoListService {

    List<ToDoList> findAll();

    ToDoList findById(Long theId);

    ToDoList save(ToDoList theToDoList);

    void delete(Long theId);


}
