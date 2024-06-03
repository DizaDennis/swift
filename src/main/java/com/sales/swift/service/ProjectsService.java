package com.sales.swift.service;


import com.sales.swift.entities.Projects;

import java.util.List;

public interface ProjectsService {

    List<Projects> findAll();
    Projects findById(Long theId);
    Projects save(Projects theProject);

    void deleteById(Long theId);
}
