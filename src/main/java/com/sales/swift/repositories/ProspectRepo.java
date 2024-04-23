package com.sales.swift.repositories;

import com.sales.swift.entities.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * ProspectRepo interface interacts with the database
 * Uses JpaRepository for the CRUD operations that it comes with
 */

public interface ProspectRepo extends JpaRepository<Prospect, Long> {

    //Method to sort by last name
    public List<Prospect> findAllByOrderByCompanyNameAsc();

}
