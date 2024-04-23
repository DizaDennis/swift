package com.sales.swift.repositories;

import com.sales.swift.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Customer Repo to interact with the DB and pull a list of customers in ascending order
 */


public interface CustomerRepo extends JpaRepository<Customer, Long > {

    List<Customer>findAllByOrderByCompanyNameAsc();
}
