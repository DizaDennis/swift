package com.sales.swift.service;


import com.sales.swift.entities.Customer;
import com.sales.swift.entities.Prospect;

import java.util.List;

/**
 * Customer service class to define methods required by/for the business logic
 */
public interface CustomerService {

    List<Customer>findAll();

    Customer findById(Long theId);

    Customer save(Customer theCustomer);

   // Customer update(Customer theCustomer);

    void deleteById(Long theId);
}
