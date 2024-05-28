package com.sales.swift.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class ToDoList {

    private Long id;
    private String Item;
    private String description;
    private Date dueDate;
    private String status;

}
