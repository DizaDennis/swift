package com.sales.swift.repositories;


import com.sales.swift.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsRepo extends JpaRepository<Projects, Long> {

    //Custom method below to sort by company name
    public List<Projects>findAllByOrderByCompanyNameAsc();

}
