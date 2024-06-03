package com.sales.swift.repositories;

import com.sales.swift.entities.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

   // List<ToDoList> findAllByDueDate(Date dueDate);
}
