package com.sales.swift.service;

import com.sales.swift.entities.ToDoList;
import com.sales.swift.repositories.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListImpl implements ToDoListService{

    private ToDoListRepo toDoListRepo;

    @Autowired
    public ToDoListImpl(ToDoListRepo theToDoListRepo){
        toDoListRepo = theToDoListRepo;
    }

    @Override
    public List<ToDoList> findAll() {
        return toDoListRepo.findAll();
    }

    @Override
    public ToDoList findById(Long theId) {

        Optional<ToDoList> result = toDoListRepo.findById(theId);

        ToDoList theToDoList = null;

        if(result.isPresent()){
            theToDoList = result.get();
        }
        else{
            throw new RuntimeException(theId + "was not found");
        }

        return theToDoList;
    }


    @Override
    public ToDoList save(ToDoList theToDoList) {
        return toDoListRepo.save(theToDoList);
    }

    @Override
    public void delete(Long theId) {
        toDoListRepo.deleteById(theId);

    }
}
